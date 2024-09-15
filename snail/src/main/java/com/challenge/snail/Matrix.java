package com.challenge.snail;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private final int[][] matrix;
    private final Position position;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.position = new Position(matrix.length, matrix[0].length);
    }

    public List<Integer> spiralOrder() {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        while (position.top <= position.bottom && position.left <= position.right) {
            for (int i = position.left; i <= position.right; i++) {
                result.add(matrix[position.top][i]);
            }
            position.top++;

            for (int i = position.top; i <= position.bottom; i++) {
                result.add(matrix[i][position.right]);
            }
            position.right--;

            if (position.top <= position.bottom) {
                for (int i = position.right; i >= position.left; i--) {
                    result.add(matrix[position.bottom][i]);
                }
                position.bottom--;
            }

            if (position.left <= position.right) {
                for (int i = position.bottom; i >= position.top; i--) {
                    result.add(matrix[i][position.left]);
                }
                position.left++;
            }
        }

        return result;
    }
}