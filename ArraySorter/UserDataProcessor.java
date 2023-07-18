package ArraySorter;

public class UserDataProcessor {
        private boolean success = true;
        private String type;
        private String values;

        private String typeOfAlgorithm;

        //These constants are only used in error messages
        private final String redColor = "\u001B[31m";
        private final String reset = "\u001B[0m";

        private final String greenColor = "\u001B[32m";


        public UserDataProcessor(String type,String typeOfAlgorithm, String values) {
            this.type = type.toLowerCase();
            this.values = values;
            this.typeOfAlgorithm = typeOfAlgorithm.toLowerCase();

            typeValidation();
            typeAlgorithmValidation();
            valuesValidation();
        }

        private void typeValidation(){
            if(!(type.equals("n") || type.equals("c"))){
                System.out.println(redColor+"[ERRO] Tipo de dados Invalidos"+reset);
                System.out.println(greenColor+"Os tipos de dados  aceitos são: C ou N"+reset);
                success = false;
            }
        }
        private void typeAlgorithmValidation(){
            if(!(typeOfAlgorithm.equals("b") || typeOfAlgorithm.equals("m") || typeOfAlgorithm.equals("q"))){
                System.out.println(redColor+"[ERRO] Tipo de algoritmo Invalido"+reset);
                System.out.println(greenColor+"Os tipos de dados  aceitos são: B, M ou Q"+reset);
                success = false;
            }
        }

        private void valuesValidation(){
            String valuesFormated = values.replaceAll("\\s*,\\s*", "");
            valuesFormated = valuesFormated.replaceAll("\\s","");

            char[] valuesChar = valuesFormated.toCharArray();

            switch (type){
                case "n":
                    for (int i = 0; i < valuesChar.length; i++) {
                        if(!(Character.isDigit(valuesChar[i]))){
                            System.out.println(redColor+"[ERRO] Os valores fornecidos não contém apenas números"+reset);
                            success = false;
                            break;
                        }
                    }
                    break;
                case "c":
                    for (int i = 0; i < valuesChar.length; i++) {
                        if(Character.isDigit(valuesChar[i])){
                            System.out.println(redColor+ "[ERRO] Os valores fornecidos contém números"+reset);
                            success = false;
                            break;
                        }
                    }
                    break;
            }
        }

        public boolean isSuccess() {
            return success;
        }
}
