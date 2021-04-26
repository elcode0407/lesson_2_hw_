public class ExceptionsHW {
    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException {
        String[][] b = new String[][]{
                {"1", "1", "3", "4"},
                {"2", "2", "2", "3"},
                {"1", "2", "2", "2"},
                {"2", "2", "4", "5"}
        };

        try {
            exc(b);
        } catch (MyArraySizeException e) {
            throw new MyArraySizeException("Массив привышает четыре!!!");
        }
    }
    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    static void exc(String[][] b) throws MyArrayDataException, MyArraySizeException {
        int x;
        if (b.length != 4) {
            throw new MyArraySizeException("Массив привышает четыре!!!");
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i].length != 4) {
                    throw new MyArraySizeException("Массив привышает четыре!!!");
                } else if (b[j].length != 4) throw new MyArraySizeException("Массив привышает четыре!!!");
                else {
                    try {
                        x = Integer.parseInt(b[i][j]);
                    } catch (NumberFormatException e) {
                        String exc = "Ошибка в ячейке: " + i + " " + j;
                        throw new MyArrayDataException(exc);
                    }
                }
                System.out.print(x);
            }
        }
    }

}
