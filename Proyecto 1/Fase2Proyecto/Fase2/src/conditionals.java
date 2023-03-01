public class conditionals {

    public static boolean conditionalCheck(int a, int b, String symbol){
        switch (symbol) {
            case ">":
                if (a > b) {
                    return true;
                }
            case "<":
                if (a < b) {
                    return true;
                }
            case ">=":
                if (a >= b) {
                    return true;
                }
            case "<=":
                if (a <= b) {
                    return true;
                }
            case "==":
                if (a == b) {
                    return true;
                }
                break;
            case "!=":
                if (a != b) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

}
