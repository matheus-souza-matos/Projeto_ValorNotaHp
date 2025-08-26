import java.util.Scanner;
import java.text.DecimalFormat;

public class emissaoNotasEmpresa {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat deci = new DecimalFormat("0.000");

        int infoNotaFiscal;
        double valorNotaFiscal, valorISS, valorRetenção, valorMaterial, valorMaoDeObra, porcentMAT, porcentMO, cargaTributária = 0.1739, issSP = 0.0500, retençãoSingularidadeSocial = 0.0350;

        System.out.println("\nBem - vindo ao sistema de cálculo para emissão de NF\n\nMe informe o valor total da NF:");
        valorNotaFiscal = input.nextDouble();

        System.out.println("\nAnotado, agora me informe se a mesma é:\n[1] - Material e FORA DE SP;\n[2] - Material e DENTRO DE SP;\n[3] - Mão de Obra fORA DE SP;\n[4] - Mão de Obra DENTRO DE SP;\n[5] - Ambos FORA DE SP;\n[6] - Ambos DENTRO DE SP;");
        infoNotaFiscal = input.nextInt();

        if (infoNotaFiscal == 1) { //Material FORA DE SP
            System.out.println("Informe para mim o valor da porcentagem do ISS SOMENTE O NÚMERO SEM O CARACTERE (%)");
            valorISS = input.nextDouble();
            double resulISS = valorNotaFiscal*valorISS/100;
            double tributariaMAT = valorNotaFiscal*cargaTributária;
            System.out.println("Parcela de Material:R$ "+ valorNotaFiscal +"\nRetenção para a Seguridade Social:R$ 0,00\nRetenção para ISS:R$ "+ deci.format(resulISS) + "\nCarga Tributária:R$ "+ deci.format(tributariaMAT));

        }else if (infoNotaFiscal == 2){  //Material DENTRO DE SP
            double resulISS = valorNotaFiscal*issSP;
            double tributariaMAT = valorNotaFiscal*cargaTributária;
            System.out.println("Parcela de Material:R$ "+ valorNotaFiscal +"\nRetenção para a Seguridade Social:R$ 0,00\nRetenção para ISS:R$ "+ deci.format(resulISS) + "\nCarga Tributária:R$ "+ deci.format(tributariaMAT));

        }else if (infoNotaFiscal == 3){ //Mão de Obra FORA DE SP
            System.out.println("Informe para mim o valor da porcentagem do ISS SOMENTE O NÚMERO SEM O CARACTERE (%)");
            valorISS = input.nextDouble();
            System.out.println("Informe para mim também o valor de porcentagem da retenção contratual SOMENTE O NÚMERO, SEM O CARACTERE");
            valorRetenção = input.nextDouble();
            double resulISS = valorNotaFiscal*valorISS/100;
            double tributariaMAT = valorNotaFiscal*cargaTributária;
            retençãoSingularidadeSocial = valorNotaFiscal*retençãoSingularidadeSocial;
            valorRetenção = valorNotaFiscal*valorRetenção/100;
            System.out.println("Parcela de Mão de Obra:R$ "+ valorNotaFiscal +"\nRetenção para a Seguridade Social:R$ "+ deci.format(retençãoSingularidadeSocial) + "\nRetenção para ISS:R$ "+ deci.format(resulISS) + "\nRetenção Contratual:R$ "+ deci.format(valorRetenção) +"\nCarga Tributária:R$ "+ deci.format(tributariaMAT));

        }else if (infoNotaFiscal == 4){ //Mão de Obra DENTRO DE SP
            System.out.println("Informe para mim o valor de porcentagem da retenção contratual SOMENTE O NÚMERO, SEM O CARACTERE");
            valorRetenção = input.nextDouble();
            double tributariaMO = valorNotaFiscal*cargaTributária;
            retençãoSingularidadeSocial = valorNotaFiscal*retençãoSingularidadeSocial;
            valorRetenção = valorNotaFiscal*valorRetenção/100;
            System.out.println("Parcela de Mão de Obra:R$ "+ valorNotaFiscal +"\nRetenção para a Seguridade Social:R$ "+ deci.format(retençãoSingularidadeSocial) + "\nRetenção Contratual:R$ "+ deci.format(valorRetenção) +"\nCarga Tributária:R$ "+ deci.format(tributariaMO));

        }else if (infoNotaFiscal == 5){ //Ambos FORA DE SP
            System.out.println("informe para mim a porcentagem de MÃO DE OBRA da Nota Fiscal (SOMENTE O NÚMERO):");
            porcentMO = input.nextDouble();
            System.out.println("Agora informe para mim a porcentagem de MATERIAL da Nota Fiscal (SOMENTE O VALOR):");
            porcentMAT = input.nextDouble();
            valorMaterial = valorNotaFiscal*porcentMAT/100;
            valorMaoDeObra = valorNotaFiscal*porcentMO/100; 
            System.out.println("Informe para mim também o valor da porcentagem do ISS SOMENTE O NÚMERO SEM O CARACTERE (%)");
            valorISS = input.nextDouble();
            System.out.println("Por último me informe o valor de porcentagem da retenção contratual SOMENTE O NÚMERO, SEM O CARACTERE");
            valorRetenção = input.nextDouble();
            double resulISS = valorNotaFiscal*valorISS/100;
            double tributariaAMB = valorNotaFiscal*cargaTributária;
            retençãoSingularidadeSocial = valorMaoDeObra*retençãoSingularidadeSocial;
            double valorRetençãoUm, valorRetençãoMO;
            valorRetençãoUm = valorNotaFiscal*valorRetenção/100;
            valorRetençãoMO = valorMaoDeObra*valorRetenção/100;
            System.out.println("\nValor total do serviço [MO + MAT]:R$ "+ valorNotaFiscal +"\nParcela de Material:R$ "+ deci.format(valorMaterial) + "\nParcela de Mão de Obra:R$ "+ deci.format(valorMaoDeObra) +"\nRetenção para a Seguridade Social:R$ "+ deci.format(retençãoSingularidadeSocial) + "\nRetenção para ISS:R$ "+ deci.format(resulISS) + "\nRetenção Contratual (SE FOR SOBRE O TOTAL):R$ "+ deci.format(valorRetençãoUm) +"Retenção Contratual (**SE FOR SOBRE MÃO DE OBRA):R$ "+ deci.format(valorRetençãoMO) +"\nCarga Tributária:R$ "+ deci.format(tributariaAMB));

        }else if (infoNotaFiscal == 6){ //Ambos DENTRO DE SP
            System.out.println("informe para mim a porcentagem de MÃO DE OBRA da Nota Fiscal (SOMENTE O NÚMERO):");
            porcentMO = input.nextDouble();
            System.out.println("Agora informe para mim a porcentagem de MATERIAL da Nota Fiscal (SOMENTE O VALOR):");
            porcentMAT = input.nextDouble();
            valorMaterial = valorNotaFiscal*porcentMAT/100;
            valorMaoDeObra = valorNotaFiscal*porcentMO/100;    
            System.out.println("Por último me informe o valor de porcentagem da retenção contratual SOMENTE O NÚMERO, SEM O CARACTERE");
            valorRetenção = input.nextDouble();
            double tributariaAMB = valorNotaFiscal*cargaTributária;
            retençãoSingularidadeSocial = valorMaoDeObra*retençãoSingularidadeSocial;
            double valorRetençãoUm, valorRetençãoMO;
            valorRetençãoUm = valorNotaFiscal*valorRetenção/100;
            valorRetençãoMO = valorMaoDeObra*valorRetenção/100;
            System.out.println("\nValor total do serviço [MO + MAT]:R$ "+ valorNotaFiscal +"\nParcela de Material:R$ "+ deci.format(valorMaterial) + "\nParcela de Mão de Obra:R$ "+ deci.format(valorMaoDeObra) +"\nRetenção para a Seguridade Social:R$ "+ deci.format(retençãoSingularidadeSocial) +"\nRetenção Contratual (SE FOR SOBRE O TOTAL):R$ "+ deci.format(valorRetençãoUm) +"\nRetenção Contratual (SE FOR SOBRE MÃO DE OBRA):R$ "+ deci.format(valorRetençãoMO) +"\nCarga Tributária:R$ "+ deci.format(tributariaAMB));
            input.close(); 
        }
    }
}