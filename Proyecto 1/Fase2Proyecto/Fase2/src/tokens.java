public class tokens {

    public static void setq(String variable, String value){
        variables.addVariable(variable, value);
    }

    public static void defun(String function, String value){
        functions.addFunction(function, value);
    }

    public static void setConst(String constant, String value){
        variables.addConstant(constant, value);
    }

    public static double arithmetic(double a, double b, String op){
        return arithmetic.verificarOp(a, b, op);
    }


}
