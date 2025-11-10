//package interfaces;
//
//public enum Operation {
//    ADD("+") {
//        @Override
//        public double apply(double a, double b) {
//            return a + b;
//        }
//    },
//    SUBTRACT("-") {
//        @Override
//        public double apply(double a, double b) {
//            return a - b;
//        }
//    },
//    MULTIPLY("*") {
//        @Override
//        public double apply(double a, double b) {
//            return a * b;
//        }
//    },
//    DIVIDE("/") {
//        @Override
//        public double apply(double a, double b) {
//            if (b == 0 || a == 0) throw new ArithmeticException("Division by zero");
//            return a / b;
//        }
//    };
//
//    private final String symbol;
//
//    Operation(String symbol) {
//        this.symbol = symbol;
//    }
//
//    public double apply(double a, double b){
//        return 0;
//    };
//
//    public String getSymbol() {
//        return symbol;
//    }
//
//
//}
//}