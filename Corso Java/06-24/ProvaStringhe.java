public class ProvaStringhe {
    public static void main(String[] args){

        //Metodo .length()
        String stringa = "Ciao";
        System.out.println("La lunghezza della stringa è: " + stringa.length()); 

        //Metodo .toUpperCase() and .toLowerCase()
        String stringa1 = "Buongiorno";
        System.out.println(stringa1.toUpperCase());
        System.out.println(stringa1.toLowerCase());

        //Metodo .indexOf()
        String stringa2 = "Please locate where 'locate' occurs!";
        System.out.println(stringa2.indexOf("where"));

        //Metodo .concat()
        String firstName = "Fabio ";
        String lastName = "Mallardo";
        System.out.println(firstName.concat(lastName));

        //Special Characters \"\"
        String stringaSpecial = "We are the so-called \"Vikings\" from the north.";
        System.out.println(stringaSpecial);

        // \t
        String stringaSpecial2 = "Ciao\tFabio";
        System.out.println(stringaSpecial2);

        // \b
        String stringaSpecial3 = "Ciao\bFabio";
        System.out.println(stringaSpecial3);

        // \f
        String stringaSpecial4 = "Ciao\fFabio";
        System.out.println(stringaSpecial4);

        // \n
        String stringaSpecial5 = "Ciao\nFabio";
        System.out.println(stringaSpecial5);

        // \r
        String stringaSpecial6 = "Ciao\rFabio";
        System.out.println(stringaSpecial6);
    }


}
