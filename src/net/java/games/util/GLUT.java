/*
 * Copyright (c) 2003 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN
 * MIDROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR
 * ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR
 * DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE
 * DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY,
 * ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, EVEN IF
 * SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed or intended for use
 * in the design, construction, operation or maintenance of any nuclear
 * facility.
 * 
 * Sun gratefully acknowledges that this software was originally authored
 * and developed by Kenneth Bradley Russell and Christopher John Kline.
 */

package net.java.games.util;

import net.java.games.jogl.*;

/** Subset of the routines provided by the GLUT interface. Note the
    signatures of many of the methods are necessarily different than
    the corresponding C version. A GLUT object must only be used from
    one particular thread at a time. <P>

    Copyright (c) Mark J. Kilgard, 1994, 1997. <P>

    (c) Copyright 1993, Silicon Graphics, Inc. <P>

    ALL RIGHTS RESERVED <P>

    Permission to use, copy, modify, and distribute this software
    for any purpose and without fee is hereby granted, provided
    that the above copyright notice appear in all copies and that
    both the copyright notice and this permission notice appear in
    supporting documentation, and that the name of Silicon
    Graphics, Inc. not be used in advertising or publicity
    pertaining to distribution of the software without specific,
    written prior permission. <P>

    THE MATERIAL EMBODIED ON THIS SOFTWARE IS PROVIDED TO YOU
    "AS-IS" AND WITHOUT WARRANTY OF ANY KIND, EXPRESS, IMPLIED OR
    OTHERWISE, INCLUDING WITHOUT LIMITATION, ANY WARRANTY OF
    MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE.  IN NO
    EVENT SHALL SILICON GRAPHICS, INC.  BE LIABLE TO YOU OR ANYONE
    ELSE FOR ANY DIRECT, SPECIAL, INCIDENTAL, INDIRECT OR
    CONSEQUENTIAL DAMAGES OF ANY KIND, OR ANY DAMAGES WHATSOEVER,
    INCLUDING WITHOUT LIMITATION, LOSS OF PROFIT, LOSS OF USE,
    SAVINGS OR REVENUE, OR THE CLAIMS OF THIRD PARTIES, WHETHER OR
    NOT SILICON GRAPHICS, INC.  HAS BEEN ADVISED OF THE POSSIBILITY
    OF SUCH LOSS, HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
    ARISING OUT OF OR IN CONNECTION WITH THE POSSESSION, USE OR
    PERFORMANCE OF THIS SOFTWARE. <P>

    US Government Users Restricted Rights <P>

    Use, duplication, or disclosure by the Government is subject to
    restrictions set forth in FAR 52.227.19(c)(2) or subparagraph
    (c)(1)(ii) of the Rights in Technical Data and Computer
    Software clause at DFARS 252.227-7013 and/or in similar or
    successor clauses in the FAR or the DOD or NASA FAR
    Supplement.  Unpublished-- rights reserved under the copyright
    laws of the United States.  Contractor/manufacturer is Silicon
    Graphics, Inc., 2011 N.  Shoreline Blvd., Mountain View, CA
    94039-7311. <P>

    OpenGL(TM) is a trademark of Silicon Graphics, Inc. <P>
*/

public class GLUT {
  public static final int STROKE_ROMAN = 0;
  public static final int STROKE_MONO_ROMAN = 1;
  public static final int BITMAP_9_BY_15 = 2;
  public static final int BITMAP_8_BY_13 = 3;
  public static final int BITMAP_TIMES_ROMAN_10 = 4;
  public static final int BITMAP_TIMES_ROMAN_24 = 5;
  public static final int BITMAP_HELVETICA_10 = 6;
  public static final int BITMAP_HELVETICA_12 = 7;
  public static final int BITMAP_HELVETICA_18 = 8;

  //----------------------------------------------------------------------
  // Shapes
  //

  public void glutWireSphere(GLU glu, double radius, int slices, int stacks) {
    quadObjInit(glu);
    glu.gluQuadricDrawStyle(quadObj, GLU.GLU_LINE);
    glu.gluQuadricNormals(quadObj, GLU.GLU_SMOOTH);
    /* If we ever changed/used the texture or orientation state
       of quadObj, we'd need to change it to the defaults here
       with gluQuadricTexture and/or gluQuadricOrientation. */
    glu.gluSphere(quadObj, radius, slices, stacks);
  }

  public void glutSolidSphere(GLU glu, double radius, int slices, int stacks) {
    quadObjInit(glu);
    glu.gluQuadricDrawStyle(quadObj, GLU.GLU_FILL);
    glu.gluQuadricNormals(quadObj, GLU.GLU_SMOOTH);
    /* If we ever changed/used the texture or orientation state
       of quadObj, we'd need to change it to the defaults here
       with gluQuadricTexture and/or gluQuadricOrientation. */
    glu.gluSphere(quadObj, radius, slices, stacks);
  }

  public void glutWireCone(GLU glu,
                           double base, double height,
                           int slices, int stacks) {
    quadObjInit(glu);
    glu.gluQuadricDrawStyle(quadObj, GLU.GLU_LINE);
    glu.gluQuadricNormals(quadObj, GLU.GLU_SMOOTH);
    /* If we ever changed/used the texture or orientation state
       of quadObj, we'd need to change it to the defaults here
       with gluQuadricTexture and/or gluQuadricOrientation. */
    glu.gluCylinder(quadObj, base, 0.0, height, slices, stacks);
  }

  public void glutSolidCone(GLU glu,
                            double base, double height,
                            int slices, int stacks) {
    quadObjInit(glu);
    glu.gluQuadricDrawStyle(quadObj, GLU.GLU_FILL);
    glu.gluQuadricNormals(quadObj, GLU.GLU_SMOOTH);
    /* If we ever changed/used the texture or orientation state
       of quadObj, we'd need to change it to the defaults here
       with gluQuadricTexture and/or gluQuadricOrientation. */
    glu.gluCylinder(quadObj, base, 0.0, height, slices, stacks);
  }

  public void glutWireCube(GL gl, float size) {
    drawBox(gl, size, GL.GL_LINE_LOOP);
  }

  public void glutSolidCube(GL gl, float size) {
    drawBox(gl, size, GL.GL_QUADS);
  }

  public void glutWireTorus(GL gl,
                            double innerRadius, double outerRadius,
                            int nsides, int rings) {
    gl.glPushAttrib(GL.GL_POLYGON_BIT);
    gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_LINE);
    doughnut(gl, innerRadius, outerRadius, nsides, rings);
    gl.glPopAttrib();
  }

  public void glutSolidTorus(GL gl,
                             double innerRadius, double outerRadius,
                             int nsides, int rings) {
    doughnut(gl, innerRadius, outerRadius, nsides, rings);
  }

  public void glutWireDodecahedron(GL gl) {
    dodecahedron(gl, GL.GL_LINE_LOOP);
  }

  public void glutSolidDodecahedron(GL gl) {
    dodecahedron(gl, GL.GL_TRIANGLE_FAN);
  }

  public void glutWireOctahedron(GL gl) {
    octahedron(gl, GL.GL_LINE_LOOP);
  }

  public void glutSolidOctahedron(GL gl) {
    octahedron(gl, GL.GL_TRIANGLES);
  }

  public void glutWireIcosahedron(GL gl) {
    icosahedron(gl, GL.GL_LINE_LOOP);
  }

  public void glutSolidIcosahedron(GL gl) {
    icosahedron(gl, GL.GL_TRIANGLES);
  }

  public void glutWireTetrahedron(GL gl) {
    tetrahedron(gl, GL.GL_LINE_LOOP);
  }

  public void glutSolidTetrahedron(GL gl) {
    tetrahedron(gl, GL.GL_TRIANGLES);
  }

  //----------------------------------------------------------------------
  // Fonts
  //

  public void glutBitmapCharacter(GL gl, int font, char character) {
    int[] swapbytes  = new int[1];
    int[] lsbfirst   = new int[1];
    int[] rowlength  = new int[1];
    int[] skiprows   = new int[1];
    int[] skippixels = new int[1];
    int[] alignment  = new int[1];
    beginBitmap(gl, 
                swapbytes,
                lsbfirst,
                rowlength,
                skiprows,
                skippixels,
                alignment);
    bitmapCharacterImpl(gl, font, character);
    endBitmap(gl, 
              swapbytes,
              lsbfirst,
              rowlength,
              skiprows,
              skippixels,
              alignment);
  }

  public void glutBitmapString   (GL gl, int font, String string) {
    int[] swapbytes  = new int[1];
    int[] lsbfirst   = new int[1];
    int[] rowlength  = new int[1];
    int[] skiprows   = new int[1];
    int[] skippixels = new int[1];
    int[] alignment  = new int[1];
    beginBitmap(gl, 
                swapbytes,
                lsbfirst,
                rowlength,
                skiprows,
                skippixels,
                alignment);
    int len = string.length();
    for (int i = 0; i < len; i++) {
      bitmapCharacterImpl(gl, font, string.charAt(i));
    }
    endBitmap(gl, 
              swapbytes,
              lsbfirst,
              rowlength,
              skiprows,
              skippixels,
              alignment);
  }

  public int  glutBitmapWidth    (int font, char character) {
    BitmapFontRec fontinfo = getBitmapFont(font);
    int c = character & 0xFFFF;
    if (c < fontinfo.first || c >= fontinfo.first + fontinfo.num_chars)
      return 0;
    BitmapCharRec ch = fontinfo.ch[c - fontinfo.first];
    if (ch != null)
      return (int) ch.advance;
    else
      return 0;
  }

  public void glutStrokeCharacter(GL gl, int font, char character) {
    StrokeFontRec fontinfo = getStrokeFont(font);
    int c = character & 0xFFFF;
    if (c < 0 || c >= fontinfo.num_chars)
      return;
    StrokeCharRec ch = fontinfo.ch[c];
    if (ch != null) {
      for (int i = 0; i < ch.num_strokes; i++) {
        StrokeRec stroke = ch.stroke[i];
        gl.glBegin(GL.GL_LINE_STRIP);
        for (int j = 0; j < stroke.num_coords; j++) {
          CoordRec coord = stroke.coord[j];
          gl.glVertex2f(coord.x, coord.y);
        }
        gl.glEnd();
      }
      gl.glTranslatef(ch.right, 0.0f, 0.0f);
    }
  }

  public void glutStrokeString(GL gl, int font, String string) {
    StrokeFontRec fontinfo = getStrokeFont(font);
    int len = string.length();
    for (int pos = 0; pos < len; pos++) {
      int c = string.charAt(pos) & 0xFFFF;
      if (c < 0 || c >= fontinfo.num_chars)
        continue;
      StrokeCharRec ch = fontinfo.ch[c];
      if (ch != null) {
        for (int i = 0; i < ch.num_strokes; i++) {
          StrokeRec stroke = ch.stroke[i];
          gl.glBegin(GL.GL_LINE_STRIP);
          for (int j = 0; j < stroke.num_coords; j++) {
            CoordRec coord = stroke.coord[j];
            gl.glVertex2f(coord.x, coord.y);
          }
          gl.glEnd();
        }
        gl.glTranslatef(ch.right, 0.0f, 0.0f);
      }
    }
  }

  public int  glutStrokeWidth    (int font, char character) {
    StrokeFontRec fontinfo = getStrokeFont(font);
    int c = character & 0xFFFF;
    if (c < 0 || c >= fontinfo.num_chars)
      return 0;
    StrokeCharRec ch = fontinfo.ch[c];
    if (ch != null)
      return (int) ch.right;
    else
      return 0;
  }

  public int  glutBitmapLength   (int font, String string) {
    BitmapFontRec fontinfo = getBitmapFont(font);
    int length = 0;
    int len = string.length();
    for (int pos = 0; pos < len; pos++) {
      int c = string.charAt(pos) & 0xFFFF;
      if (c >= fontinfo.first && c < fontinfo.first + fontinfo.num_chars) {
        BitmapCharRec ch = fontinfo.ch[c - fontinfo.first];
        if (ch != null)
          length += ch.advance;
      }
    }
    return length;
  }

  public int  glutStrokeLength   (int font, String string) {
    StrokeFontRec fontinfo = getStrokeFont(font);
    int length = 0;
    int len = string.length();
    for (int i = 0; i < len; i++) {
      char c = string.charAt(i);
      if (c >= 0 && c < fontinfo.num_chars) {
        StrokeCharRec ch = fontinfo.ch[c];
        if (ch != null)
          length += ch.right;
      }
    }
    return length;
  }

  //----------------------------------------------------------------------
  // Internals only below this point
  //

  //----------------------------------------------------------------------
  // Shape implementation
  //

  private GLUquadric quadObj;
  private void quadObjInit(GLU glu) {
    if (quadObj == null) {
      quadObj = glu.gluNewQuadric();
    }
    if (quadObj == null) {
      throw new GLException("Out of memory");
    }
  }

  private static void doughnut(GL gl, double r, double R, int nsides, int rings) {
    int i, j;
    float theta, phi, theta1;
    float cosTheta, sinTheta;
    float cosTheta1, sinTheta1;
    float ringDelta, sideDelta;

    ringDelta = (float) (2.0 * Math.PI / rings);
    sideDelta = (float) (2.0 * Math.PI / nsides);

    theta = 0.0f;
    cosTheta = 1.0f;
    sinTheta = 0.0f;
    for (i = rings - 1; i >= 0; i--) {
      theta1 = theta + ringDelta;
      cosTheta1 = (float) Math.cos(theta1);
      sinTheta1 = (float) Math.sin(theta1);
      gl.glBegin(GL.GL_QUAD_STRIP);
      phi = 0.0f;
      for (j = nsides; j >= 0; j--) {
        float cosPhi, sinPhi, dist;

        phi += sideDelta;
        cosPhi = (float) Math.cos(phi);
        sinPhi = (float) Math.sin(phi);
        dist = (float) (R + r * cosPhi);

        gl.glNormal3f(cosTheta1 * cosPhi, -sinTheta1 * cosPhi, sinPhi);
        gl.glVertex3f(cosTheta1 * dist,   -sinTheta1 * dist,   (float) r * sinPhi);
        gl.glNormal3f(cosTheta  * cosPhi, -sinTheta  * cosPhi, sinPhi);
        gl.glVertex3f(cosTheta  * dist,   -sinTheta  * dist,   (float) r * sinPhi);
      }
      gl.glEnd();
      theta = theta1;
      cosTheta = cosTheta1;
      sinTheta = sinTheta1;
    }
  }

  private static final float[][] boxNormals = {
    {-1.0f, 0.0f, 0.0f},
    {0.0f, 1.0f, 0.0f},
    {1.0f, 0.0f, 0.0f},
    {0.0f, -1.0f, 0.0f},
    {0.0f, 0.0f, 1.0f},
    {0.0f, 0.0f, -1.0f}
  };
  private static final int[][] boxFaces = {
    {0, 1, 2, 3},
    {3, 2, 6, 7},
    {7, 6, 5, 4},
    {4, 5, 1, 0},
    {5, 6, 2, 1},
    {7, 4, 0, 3}
  };
  private float[][] boxVertices;
  private void drawBox(GL gl, float size, int type) {
    if (boxVertices == null) {
      float[][] v = new float[8][];
      for (int i = 0; i < 8; i++) {
        v[i] = new float[3];
      }
      v[0][0] = v[1][0] = v[2][0] = v[3][0] = -size / 2;
      v[4][0] = v[5][0] = v[6][0] = v[7][0] = size / 2;
      v[0][1] = v[1][1] = v[4][1] = v[5][1] = -size / 2;
      v[2][1] = v[3][1] = v[6][1] = v[7][1] = size / 2;
      v[0][2] = v[3][2] = v[4][2] = v[7][2] = -size / 2;
      v[1][2] = v[2][2] = v[5][2] = v[6][2] = size / 2;
      boxVertices = v;
    }
    float[][] v = boxVertices;
    float[][] n = boxNormals;
    int[][] faces = boxFaces;
    for (int i = 5; i >= 0; i--) {
      gl.glBegin(type);
      gl.glNormal3fv(n[i]);
      gl.glVertex3fv(v[faces[i][0]]);
      gl.glVertex3fv(v[faces[i][1]]);
      gl.glVertex3fv(v[faces[i][2]]);
      gl.glVertex3fv(v[faces[i][3]]);
      gl.glEnd();
    }
  }

  private float[][] dodec;

  private void initDodecahedron() {
    dodec = new float[20][];
    for (int i = 0; i < dodec.length; i++) {
      dodec[i] = new float[3];
    }

    float alpha, beta;

    alpha = (float) Math.sqrt(2.0f / (3.0f + Math.sqrt(5.0)));
    beta = 1.0f + (float) Math.sqrt(6.0 / (3.0 + Math.sqrt(5.0)) -
                                    2.0 + 2.0 * Math.sqrt(2.0 / (3.0 + Math.sqrt(5.0))));
    dodec[0][0] = -alpha; dodec[0][1] = 0; dodec[0][2] = beta;
    dodec[1][0] = alpha; dodec[1][1] = 0; dodec[1][2] = beta;
    dodec[2][0] = -1; dodec[2][1] = -1; dodec[2][2] = -1;
    dodec[3][0] = -1; dodec[3][1] = -1; dodec[3][2] = 1;
    dodec[4][0] = -1; dodec[4][1] = 1; dodec[4][2] = -1;
    dodec[5][0] = -1; dodec[5][1] = 1; dodec[5][2] = 1;
    dodec[6][0] = 1; dodec[6][1] = -1; dodec[6][2] = -1;
    dodec[7][0] = 1; dodec[7][1] = -1; dodec[7][2] = 1;
    dodec[8][0] = 1; dodec[8][1] = 1; dodec[8][2] = -1;
    dodec[9][0] = 1; dodec[9][1] = 1; dodec[9][2] = 1;
    dodec[10][0] = beta; dodec[10][1] = alpha; dodec[10][2] = 0;
    dodec[11][0] = beta; dodec[11][1] = -alpha; dodec[11][2] = 0;
    dodec[12][0] = -beta; dodec[12][1] = alpha; dodec[12][2] = 0;
    dodec[13][0] = -beta; dodec[13][1] = -alpha; dodec[13][2] = 0;
    dodec[14][0] = -alpha; dodec[14][1] = 0; dodec[14][2] = -beta;
    dodec[15][0] = alpha; dodec[15][1] = 0; dodec[15][2] = -beta;
    dodec[16][0] = 0; dodec[16][1] = beta; dodec[16][2] = alpha;
    dodec[17][0] = 0; dodec[17][1] = beta; dodec[17][2] = -alpha;
    dodec[18][0] = 0; dodec[18][1] = -beta; dodec[18][2] = alpha;
    dodec[19][0] = 0; dodec[19][1] = -beta; dodec[19][2] = -alpha;
  }

  private static void diff3(float[] a, float[] b, float[] c) {
    c[0] = a[0] - b[0];
    c[1] = a[1] - b[1];
    c[2] = a[2] - b[2];
  }

  private static void crossprod(float[] v1, float[] v2, float[] prod) {
    float[] p = new float[3];         /* in case prod == v1 or v2 */

    p[0] = v1[1] * v2[2] - v2[1] * v1[2];
    p[1] = v1[2] * v2[0] - v2[2] * v1[0];
    p[2] = v1[0] * v2[1] - v2[0] * v1[1];
    prod[0] = p[0];
    prod[1] = p[1];
    prod[2] = p[2];
  }

  private static void normalize(float[] v) {
    float d;

    d = (float) Math.sqrt(v[0] * v[0] + v[1] * v[1] + v[2] * v[2]);
    if (d == 0.0) {
      v[0] = d = 1.0f;
    }
    d = 1 / d;
    v[0] *= d;
    v[1] *= d;
    v[2] *= d;
  }

  private void pentagon(GL gl, int a, int b, int c, int d, int e, int shadeType) {
    float[] n0 = new float[3];
    float[] d1 = new float[3];
    float[] d2 = new float[3];

    diff3(dodec[a], dodec[b], d1);
    diff3(dodec[b], dodec[c], d2);
    crossprod(d1, d2, n0);
    normalize(n0);

    gl.glBegin(shadeType);
    gl.glNormal3fv(n0);
    gl.glVertex3fv(dodec[a]);
    gl.glVertex3fv(dodec[b]);
    gl.glVertex3fv(dodec[c]);
    gl.glVertex3fv(dodec[d]);
    gl.glVertex3fv(dodec[e]);
    gl.glEnd();
  }

  private void dodecahedron(GL gl, int type) {
    if (dodec == null) {
      initDodecahedron();
    }
    pentagon(gl, 0, 1, 9, 16, 5, type);
    pentagon(gl, 1, 0, 3, 18, 7, type);
    pentagon(gl, 1, 7, 11, 10, 9, type);
    pentagon(gl, 11, 7, 18, 19, 6, type);
    pentagon(gl, 8, 17, 16, 9, 10, type);
    pentagon(gl, 2, 14, 15, 6, 19, type);
    pentagon(gl, 2, 13, 12, 4, 14, type);
    pentagon(gl, 2, 19, 18, 3, 13, type);
    pentagon(gl, 3, 0, 5, 12, 13, type);
    pentagon(gl, 6, 15, 8, 10, 11, type);
    pentagon(gl, 4, 17, 8, 15, 14, type);
    pentagon(gl, 4, 12, 5, 16, 17, type);
  }

  private static void recorditem(GL gl, float[] n1, float[] n2, float[] n3, int shadeType) {
    float[] q0 = new float[3];
    float[] q1 = new float[3];

    diff3(n1, n2, q0);
    diff3(n2, n3, q1);
    crossprod(q0, q1, q1);
    normalize(q1);

    gl.glBegin(shadeType);
    gl.glNormal3fv(q1);
    gl.glVertex3fv(n1);
    gl.glVertex3fv(n2);
    gl.glVertex3fv(n3);
    gl.glEnd();
  }

  private static void subdivide(GL gl, float[] v0, float[] v1, float[] v2, int shadeType) {
    int depth;
    float[] w0 = new float[3];
    float[] w1 = new float[3];
    float[] w2 = new float[3];
    float l;
    int i, j, k, n;

    depth = 1;
    for (i = 0; i < depth; i++) {
      for (j = 0; i + j < depth; j++) {
        k = depth - i - j;
        for (n = 0; n < 3; n++) {
          w0[n] = (i * v0[n] + j * v1[n] + k * v2[n]) / depth;
          w1[n] = ((i + 1) * v0[n] + j * v1[n] + (k - 1) * v2[n])
            / depth;
          w2[n] = (i * v0[n] + (j + 1) * v1[n] + (k - 1) * v2[n])
            / depth;
        }
        l = (float) Math.sqrt(w0[0] * w0[0] + w0[1] * w0[1] + w0[2] * w0[2]);
        w0[0] /= l;
        w0[1] /= l;
        w0[2] /= l;
        l = (float) Math.sqrt(w1[0] * w1[0] + w1[1] * w1[1] + w1[2] * w1[2]);
        w1[0] /= l;
        w1[1] /= l;
        w1[2] /= l;
        l = (float) Math.sqrt(w2[0] * w2[0] + w2[1] * w2[1] + w2[2] * w2[2]);
        w2[0] /= l;
        w2[1] /= l;
        w2[2] /= l;
        recorditem(gl, w1, w0, w2, shadeType);
      }
    }
  }

  private static void drawtriangle(GL gl, int i, float[][] data, int[][] ndx, int shadeType) {
    float[] x0 = data[ndx[i][0]];
    float[] x1 = data[ndx[i][1]];
    float[] x2 = data[ndx[i][2]];
    subdivide(gl, x0, x1, x2, shadeType);
  }

  /* octahedron data: The octahedron produced is centered at the
     origin and has radius 1.0 */
  private static final float[][] odata =
  {
    {1.0f, 0.0f, 0.0f},
    {-1.0f, 0.0f, 0.0f},
    {0.0f, 1.0f, 0.0f},
    {0.0f, -1.0f, 0.0f},
    {0.0f, 0.0f, 1.0f},
    {0.0f, 0.0f, -1.0f}
  };

  private static final int[][] ondex =
  {
    {0, 4, 2},
    {1, 2, 4},
    {0, 3, 4},
    {1, 4, 3},
    {0, 2, 5},
    {1, 5, 2},
    {0, 5, 3},
    {1, 3, 5}
  };

  private static void octahedron(GL gl, int shadeType) {
    int i;

    for (i = 7; i >= 0; i--) {
      drawtriangle(gl, i, odata, ondex, shadeType);
    }
  }

  /* icosahedron data: These numbers are rigged to make an
     icosahedron of radius 1.0 */

  private static final float X = .525731112119133606f;
  private static final float Z = .850650808352039932f;

  private static final float[][] idata =
  {
    {-X, 0, Z},
    {X, 0, Z},
    {-X, 0, -Z},
    {X, 0, -Z},
    {0, Z, X},
    {0, Z, -X},
    {0, -Z, X},
    {0, -Z, -X},
    {Z, X, 0},
    {-Z, X, 0},
    {Z, -X, 0},
    {-Z, -X, 0}
  };

  private static final int[][] index =
  {
    {0, 4, 1},
    {0, 9, 4},
    {9, 5, 4},
    {4, 5, 8},
    {4, 8, 1},
    {8, 10, 1},
    {8, 3, 10},
    {5, 3, 8},
    {5, 2, 3},
    {2, 7, 3},
    {7, 10, 3},
    {7, 6, 10},
    {7, 11, 6},
    {11, 0, 6},
    {0, 1, 6},
    {6, 1, 10},
    {9, 0, 11},
    {9, 11, 2},
    {9, 2, 5},
    {7, 2, 11},
  };

  private static void icosahedron(GL gl, int shadeType) {
    int i;

    for (i = 19; i >= 0; i--) {
      drawtriangle(gl, i, idata, index, shadeType);
    }
  }

  /* tetrahedron data: */

  private static final float T = 1.73205080756887729f;

  private static final float[][] tdata =
  {
    {T, T, T},
    {T, -T, -T},
    {-T, T, -T},
    {-T, -T, T}
  };

  private static final int[][] tndex =
  {
    {0, 1, 3},
    {2, 1, 0},
    {3, 2, 0},
    {1, 2, 3}
  };

  private static final void tetrahedron(GL gl, int shadeType) {
    for (int i = 3; i >= 0; i--)
      drawtriangle(gl, i, tdata, tndex, shadeType);
  }

  //----------------------------------------------------------------------
  // Font implementation
  //

  private static void bitmapCharacterImpl(GL gl, int font, char cin) {
    BitmapFontRec fontinfo = getBitmapFont(font);
    int c = cin & 0xFFFF;
    if (c < fontinfo.first ||
        c >= fontinfo.first + fontinfo.num_chars)
      return;
    BitmapCharRec ch = fontinfo.ch[c - fontinfo.first];
    if (ch != null) {
      gl.glBitmap(ch.width, ch.height, ch.xorig, ch.yorig,
                  ch.advance, 0, ch.bitmap);
    }
  }

  private static final BitmapFontRec[] bitmapFonts = new BitmapFontRec[9];
  private static final StrokeFontRec[] strokeFonts = new StrokeFontRec[9];

  private static BitmapFontRec getBitmapFont(int font) {
    BitmapFontRec rec = bitmapFonts[font];
    if (rec == null) {
      switch (font) {
        case BITMAP_9_BY_15:
          rec = GLUTBitmap9x15.glutBitmap9By15;
          break;
        case BITMAP_8_BY_13:
          rec = GLUTBitmap8x13.glutBitmap8By13;
          break;
        case BITMAP_TIMES_ROMAN_10:
          rec = GLUTBitmapTimesRoman10.glutBitmapTimesRoman10;
          break;
        case BITMAP_TIMES_ROMAN_24:
          rec = GLUTBitmapTimesRoman24.glutBitmapTimesRoman24;
          break;
        case BITMAP_HELVETICA_10:
          rec = GLUTBitmapHelvetica10.glutBitmapHelvetica10;
          break;
        case BITMAP_HELVETICA_12:
          rec = GLUTBitmapHelvetica12.glutBitmapHelvetica12;
          break;
        case BITMAP_HELVETICA_18:
          rec = GLUTBitmapHelvetica18.glutBitmapHelvetica18;
          break;
        default:
          throw new GLException("Unknown bitmap font number " + font);
      }
      bitmapFonts[font] = rec;
    }
    return rec;
  }

  private static StrokeFontRec getStrokeFont(int font) {
    StrokeFontRec rec = strokeFonts[font];
    if (rec == null) {
      switch (font) {
        case STROKE_ROMAN:
          rec = GLUTStrokeRoman.glutStrokeRoman;
          break;
        case STROKE_MONO_ROMAN:
          rec = GLUTStrokeMonoRoman.glutStrokeMonoRoman;
          break;
        default:
          throw new GLException("Unknown stroke font number " + font);
      }
    }
    return rec;
  }

  private static void beginBitmap(GL gl,
                                  int[] swapbytes,
                                  int[] lsbfirst,
                                  int[] rowlength,
                                  int[] skiprows,
                                  int[] skippixels,
                                  int[] alignment) {
    gl.glGetIntegerv(GL.GL_UNPACK_SWAP_BYTES, swapbytes);
    gl.glGetIntegerv(GL.GL_UNPACK_LSB_FIRST, lsbfirst);
    gl.glGetIntegerv(GL.GL_UNPACK_ROW_LENGTH, rowlength);
    gl.glGetIntegerv(GL.GL_UNPACK_SKIP_ROWS, skiprows);
    gl.glGetIntegerv(GL.GL_UNPACK_SKIP_PIXELS, skippixels);
    gl.glGetIntegerv(GL.GL_UNPACK_ALIGNMENT, alignment);
    /* Little endian machines (DEC Alpha for example) could
       benefit from setting GL_UNPACK_LSB_FIRST to GL_TRUE
       instead of GL_FALSE, but this would require changing the
       generated bitmaps too. */
    gl.glPixelStorei(GL.GL_UNPACK_SWAP_BYTES, GL.GL_FALSE);
    gl.glPixelStorei(GL.GL_UNPACK_LSB_FIRST, GL.GL_FALSE);
    gl.glPixelStorei(GL.GL_UNPACK_ROW_LENGTH, 0);
    gl.glPixelStorei(GL.GL_UNPACK_SKIP_ROWS, 0);
    gl.glPixelStorei(GL.GL_UNPACK_SKIP_PIXELS, 0);
    gl.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 1);
  }

  private static void endBitmap(GL gl,
                                int[] swapbytes,
                                int[] lsbfirst,
                                int[] rowlength,
                                int[] skiprows,
                                int[] skippixels,
                                int[] alignment) {
    /* Restore saved modes. */
    gl.glPixelStorei(GL.GL_UNPACK_SWAP_BYTES, swapbytes[0]);
    gl.glPixelStorei(GL.GL_UNPACK_LSB_FIRST, lsbfirst[0]);
    gl.glPixelStorei(GL.GL_UNPACK_ROW_LENGTH, rowlength[0]);
    gl.glPixelStorei(GL.GL_UNPACK_SKIP_ROWS, skiprows[0]);
    gl.glPixelStorei(GL.GL_UNPACK_SKIP_PIXELS, skippixels[0]);
    gl.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, alignment[0]);
  }
}
