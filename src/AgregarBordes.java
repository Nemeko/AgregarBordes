

public class AgregarBordes {
    
    private String clr = "\u001B[0m";
    private String rst = "\u001B[0m";
    
    private String bordeSupIzq = "\u2554";
    private String bordeSupDer = "\u2557";
    private String bordeInfIzq = "\u255A";
    private String bordeInfDer = "\u255D";
    private String bordeH = "\u2550";
    private String bordeV = "\u2551";

    public AgregarBordes(){
    }

    public AgregarBordes(String selectorColor){
        colorBorde(selectorColor);
    }

    private String selectorColor(String selectorColor){
        switch (selectorColor){
        case "black": return "\033[30m";
        case "red": return "\033[31m";
        case "green": return "\033[32m";
        case "yellow": return "\033[33m";
        case "blue":  return "\033[34m";
        case "purple": return "\033[35m";
        case "cyan": return "\033[36m";
        case "grey": return "\033[37m";           
        default: return "\u001B[0m";
        }
    }

    private void color(String clr){
        bordeSupIzq = clr+"\u2554"+rst;
        bordeSupDer = clr+"\u2557"+rst;
        bordeInfIzq = clr+"\u255A"+rst;
        bordeInfDer = clr+"\u255D"+rst;
        bordeH = clr+"\u2550"+rst;
        bordeV = clr+"\u2551"+rst;
    }
    
    public void colorBorde(String selectorColor){
        color(selectorColor(selectorColor));
    }

    public void contenido(String contenido){
        separadorRenglones(contenido);
    }

    public void contenido(String contenido, String colorTexto){
        this.clr = selectorColor(colorTexto);
        separadorRenglones(contenido);
        this.clr = this.rst;
    }

    private void separadorRenglones (String frase){
        String[] renglones = frase.split("\n");
        String bordeArriba=this.bordeSupIzq;
        String bordeAbajo=this.bordeInfIzq;
        int largoRenglon = 0;

        for(int i=0; i<renglones.length; i++){
            if(largoRenglon < renglones[i].length()) largoRenglon = renglones[i].length();
        }

        for(int i=0; i<=largoRenglon+1; i++){
            bordeArriba += this.bordeH;
            bordeAbajo += this.bordeH;
        }
        
        bordeArriba += this.bordeSupDer;
        bordeAbajo += this.bordeInfDer;

        System.out.println(bordeArriba);

        for(int i=0; i<renglones.length; i++){
            int espaciosAgregarRenglon = largoRenglon - renglones[i].length();
            for(int j=0; j<= espaciosAgregarRenglon; j++)renglones[i] += " ";
            System.out.println(this.bordeV+" "+this.clr+renglones[i]+this.rst+this.bordeV);
        }
        
        System.out.println(bordeAbajo);
    }
}

/*
* CodigoEscape [ Estilo ; clrTexto ; clrFondo m
* \033[1;35m;
*/

/*
* clr de texto (+30)
* String black="\033[30m";
* String red="\033[31m";
* String green="\033[32m";
* String yellow="\033[33m";
* String blue="\033[34m";
* String purple="\033[35m";
* String cyan="\033[36m";
* String grey="\033[37m";
* String reset="\u001B[0m";
* 
* clr de fondo (+40)
* String black= 40
* String red= 41
* String green= 42
* String yellow= 43
* String blue= 44
* String purple= 45
* String cyan= 46
* String grey= 47
*/

/*
* Estilo:
* Normal/Defecto 0
* Negrita 1
* Atenuado 2
* Cursiva 3
* Subrayado 4
* Parpadeo 5
* Parpadeo intenso 6
* Invertido 7
* Oculto 8
* Tachado 9
*/
