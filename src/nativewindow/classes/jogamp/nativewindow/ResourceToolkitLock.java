/**
 * Copyright 2012 JogAmp Community. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY JogAmp Community ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL JogAmp Community OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of JogAmp Community.
 */

package jogamp.nativewindow;

import javax.media.nativewindow.ToolkitLock;

import com.jogamp.common.util.locks.LockFactory;
import com.jogamp.common.util.locks.RecursiveLock;

/**
 * Implementing a resource based recursive {@link javax.media.nativewindow.ToolkitLock}.
 * <p>
 * A resource handle maybe used within a unique object
 * and can be synchronized across threads via an instance of ResourceToolkitLock.
 * </p>
 */
public class ResourceToolkitLock implements ToolkitLock {
    public static final ResourceToolkitLock create() {
        return new ResourceToolkitLock();
    }

    private final RecursiveLock lock;

    private ResourceToolkitLock() {
        this.lock = LockFactory.createRecursiveLock();
    }

    @Override
    public final void lock() {
        lock.lock();
        if(TRACE_LOCK) { System.err.println("ResourceToolkitLock.lock()"); }
    }

    @Override
    public final void unlock() {
        if(TRACE_LOCK) { System.err.println("ResourceToolkitLock.unlock()"); }
        lock.unlock(); // implicit lock validation
    }

    @Override
    public final void validateLocked() throws RuntimeException {
        lock.validateLocked();
    }

    @Override
    public final void dispose() {
        // nop
    }

    @Override
    public String toString() {
        return "ResourceToolkitLock[obj 0x"+Integer.toHexString(hashCode())+", isOwner "+lock.isOwner(Thread.currentThread())+", "+lock.toString()+"]";
    }
}
