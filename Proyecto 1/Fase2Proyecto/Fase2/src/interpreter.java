public class interpreter {

    public String[] parser(String input){
        String[] tokens = input.split(" ");
        return tokens;
    }

    public void instructionReader(String[] tokens){
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }

    public void verifier(String[] tokens){
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("print")){
                System.out.println(tokens[i+1]);
            }
        }
    }

}
