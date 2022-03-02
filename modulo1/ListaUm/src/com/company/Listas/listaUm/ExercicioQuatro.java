package com.company.Listas.listaUm;

import java.util.Scanner;

public class ExercicioQuatro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String estado, cidade;
        System.out.println("Por favor, escolha entre os estados RS, PB e MG");

        estado = scanner.nextLine();

        if (estado.toUpperCase().contentEquals("RS")){
            System.out.println("Por favor, escolha entre as cidades Butiá e Porto Alegre");
            cidade = scanner.nextLine();
            if(cidade.toUpperCase().contentEquals("BUTIÁ")){
                System.out.println("História\nFundação\t1881\n" +
                        "Emancipação\t9 de outubro de 1963 (58 anos)\n" +
                        "Administração\n" +
                        "Prefeito(a)\tDaniel Pereira de Almeida (PT, 2021 – 2024)\n" +
                        "Características geográficas\n" +
                        "Área total [1]\t768,889 km²\n" +
                        "População total (est. IBGE/2016[2])\t21 220 hab.\n" +
                        "Densidade\t27,6 hab./km²\n" +
                        "Clima\tSubtropical úmido\n" +
                        "Altitude\t71 m\n" +
                        "Fuso horário\tHora de Brasília (UTC−3)\n" +
                        "Indicadores\n" +
                        "IDH (PNUD/2000 [3])\t0,755 — alto");
            }
            else
                if(cidade.toUpperCase().contentEquals("PORTO ALEGRE")){
                    System.out.println("História\nFundação\t26 de março de 1772 (249 anos)\n" +
                            "Emancipação\t11 de dezembro de 1810 (211 anos)\n" +
                            "Aniversário\t26 de março\n" +
                            "Administração\n" +
                            "Prefeito(a)\tSebastião Melo (MDB, 2021 – 2024)\n" +
                            "Características geográficas\n" +
                            "Área total [3]\t496,682 km²\n" +
                            " • Área urbana  Embrapa/2015[4]\t306,36 km²\n" +
                            "População total (estatísticas IBGE/2021[5])\t1 492 530 hab.\n" +
                            " • Posição\tRS: 1º\n" +
                            "Densidade\t3 005 hab./km²\n" +
                            "Clima\tsubtropical úmido (Cfa)\n" +
                            "Altitude\t10 m\n" +
                            "Fuso horário\tHora de Brasília (UTC−3)\n" +
                            "CEP\t90000-000 até 91999-999\n" +
                            "Indicadores\n" +
                            "IDH (PNUD/2010[6])\t0,805 — muito alto"); }
                else {System.out.println("cidade inválida");
                }
        }
        else
            if(estado.toUpperCase().contentEquals("PB")){
                System.out.println("Por favor, escolha entre as cidades Água Branca e Aguiar");
                cidade = scanner.nextLine();
                if(cidade.toUpperCase().contentEquals("ÁGUA BRANCA")){
                    System.out.println("História\n" +
                            "Fundação\t24 de setembro de 1959 (62 anos)\n" +
                            "Aniversário\t24 de setembro\n" +
                            "Administração\n" +
                            "Prefeito(a)\tEverton Firmino Batista (MDB, 2021 – 2024)\n" +
                            "Características geográficas\n" +
                            "Área total [3]\t220,648 km²\n" +
                            "População total (2017)\t10 258 hab.\n" +
                            "Densidade\t46,5 hab./km²\n" +
                            "Clima\tsemiárido[2]\n" +
                            "Altitude\t735 m\n" +
                            "Fuso horário\tHora de Brasília (UTC−3)\n" +
                            "Indicadores\n" +
                            "IDH (PNUD/2010[4])\t0,572 — baixo");
                }
                else
                if(cidade.toUpperCase().contentEquals("AGUIAR")){
                    System.out.println("História\nFundação\t22 de dezembro 1961\n" +
                            "Emancipação\t22 de dezembro de 1961 (60 anos)\n" +
                            "Administração\n" +
                            "Prefeito(a)\tManoel Batista Guedes Filho (PTB, 2021 – 2024)\n" +
                            "Características geográficas\n" +
                            "Área total [2]\t344,691 km²\n" +
                            "População total (IBGE/2016[3])\t5 567 hab.\n" +
                            "Densidade\t16,2 hab./km²\n" +
                            "Clima\tclima semiárido (BSwh)\n" +
                            "Altitude\t262 m\n" +
                            "Fuso horário\tHora de Brasília (UTC−3)\n" +
                            "CEP\t58778-000\n" +
                            "Indicadores\n" +
                            "IDH (PNUD/2010 [4])\t0,597 — baixo");
                }
                else {System.out.println("cidade inválida");
                }
            }
            else
                if(estado.toUpperCase().contentEquals("MG")){
                    System.out.println("Por favor, escolha entre as cidades Belo Horizonte e Uberlândia");
                    cidade = scanner.nextLine();
                    if(cidade.toUpperCase().contentEquals("BELO HORIZONTE")){
                        System.out.println("História\n" +
                                "Fundação\t12 de dezembro de 1897 (124 anos)\n" +
                                "Aniversário\t12 de dezembro\n" +
                                "Administração\n" +
                                "Distritos\t\n" +
                                "Lista[Expandir]\n" +
                                "Prefeito(a)\tAlexandre Kalil (PSD, 2021 – 2024)\n" +
                                "Características geográficas\n" +
                                "Área total [7]\t331,354 km²\n" +
                                "População total (Estimativa IBGE/2021[7])\t2 530 701 hab.\n" +
                                " • Posição\tMG: 1º; BR: 6º\n" +
                                "Densidade\t7 637,5 hab./km²\n" +
                                "Clima\tTropical com estação seca (Aw)\n" +
                                "Altitude [8]\t852 m\n" +
                                "Fuso horário\tHora de Brasília (UTC−3)\n" +
                                "CEP\t30000-000 a 31999-999[6]\n" +
                                "Indicadores\n" +
                                "IDH (PNUD/2010[9])\t0,810 — muito alto");
                    }
                    else
                    if(cidade.toUpperCase().contentEquals("UBERLÂNDIA")){
                        System.out.println("História\n" +
                                "Fundação\t31 de agosto de 1888 (133 anos)\n" +
                                "Aniversário\t31 de agosto\n" +
                                "Administração\n" +
                                "Prefeito(a)\tOdelmo Leão Carneiro Sobrinho (PP, 2021 – 2024)\n" +
                                "Características geográficas\n" +
                                "Área total [1]\t4 115,206 km²\n" +
                                "População total (estimativa IBGE/2021[1])\t706 597 hab.\n" +
                                " • Posição\tMG: 2º; BR: 30º\n" +
                                "Densidade\t171,7 hab./km²\n" +
                                "Clima\ttropical com estação seca (Aw)\n" +
                                "Altitude\t863 m\n" +
                                "Fuso horário\tHora de Brasília (UTC−3)\n" +
                                "CEP\t38400-000 a 38439-999[4]\n" +
                                "Indicadores\n" +
                                "IDH (PNUD/2010[5])\t0,789 — alto");
                    }
                    else {System.out.println("cidade inválida");
                    }
                }
                else {
                    System.out.println("Estado inválido");
                }





    }
}
