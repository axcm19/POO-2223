/*
ESTA CLASSE É RESPONSÁVEL POR TODOS OS MÉTODOS QUE PERMITEM SALVAR E RECUPERAR O ESTADO DO PROGRAMA
(MUITO INACABADO!!!)
 */

import java.io.*;
import java.util.*;

public class DataManager {

    // maps onde se vai guardar a informação retirada dos ficheiros que guardam o estado do programa
    private Map<String, Artigo> artigoMap;
    private Map<String, Utilizador> utilizadorMap;
    private Map<String, Encomenda> encomendaMap;
    private Map<String, Transportadora> transportadoraMap;

    public DataManager() {
        this.artigoMap = new HashMap<>();
        this.utilizadorMap = new HashMap<>();
        this.encomendaMap = new HashMap<>();
        this.transportadoraMap = new HashMap<>();
    }

    public static TreeSet<Artigo> loadArtigos() throws IOException, ClassNotFoundException {
        new File("artigos.bin");
        TreeSet<Artigo> artigos = null;
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("artigos.bin"));
        artigos = (TreeSet)input.readObject();
        input.close();
        return artigos;
    }

    public static List<Artigo> loadArtigos_STATIC() {

        Transportadora fedex = new Transportadora("FedEx", 0.4, 0.55);
        Transportadora ctt = new Transportadora("CTT", 0.5, 0.45);
        Transportadora  chronopost = new Transportadora(" Chronopost", 0.3, 0.8);

        // Sapatilhas
        Artigo a1 = new Sapatilha("novo", "Sapatilhas muito bonitas", "Rebook", 32.45, 0.3, 0, fedex, 43, "atacadores", "vermelho", "2023-02-27");
        Artigo a2 = new Sapatilha("novo", "Sapatilhas ainda mais bonitas", "Adidas", 44.50, 0.2, 0, ctt, 40, "atilhos", "verde", "2023-01-01");
        Artigo a3 = new Sapatilha("usado", "Sapatilhas um bocado usadas mais ainda boas", "Geox", 10, 0.1, 1, chronopost, 38, "atacadores", "branco", "2022-11-10");
        Artigo a4 = new Sapatilha("usado", "Sapatilhas usadas em bom estado", "Nike", 15, 0.15, 1, fedex, 41, "atacadores", "branco", "2018-09-12");
        Artigo a5 = new Sapatilha("novo", "Sapatilhas New Balance coleção 2023", "New Balance", 46.80, 0.2, 0, ctt, 42, "atacadores", "azul", "2023-03-10");
        Artigo a6 = new Sapatilha("novo", "Sapatilhas de boa marca", "Adidas", 35.60, 0.2, 0, chronopost, 46, "atilhos", "roxo", "2023-04-01");
        Artigo a7 = new Sapatilha("usado", "Sapatos em bom estado", "Calvin Klein", 45, 0.35, 1, ctt, 41, "atilhos", "bege", "2020-08-12");
        Artigo a8 = new Sapatilha("usado", "Botas usadas de qualidade", "Timberland", 21, 0.2, 2, fedex, 42, "atacadores", "castanho", "2019-11-12");
        Artigo a9 = new Sapatilha("usado", "Sapatilhas de corrida em bom estado", "Puma", 25, 0.22, 1, chronopost, 39, "atacadores", "amarelo", "2021-05-04");
        Artigo a10 = new Sapatilha("novo", "Sapatilhas novas da Nike", "Nike", 48, 0.19, 0, ctt, 40, "atacadores", "vermelho", "2023-05-04");
        Artigo a11 = new Sapatilha("usado", "Sapatos usados Michael Kors", "Michael Kors", 40, 0.23, 1, fedex, 38, "atacadores", "preto", "2020-04-23");
        Artigo a12 = new Sapatilha("usado", "Botas de senhora usados", "Calvin Klein", 37, 0.11, 1, chronopost, 39, "atilhos", "preto", "2022-06-13");
        Artigo a13 = new Sapatilha("novo", "Sapatilhas novas para menina", "Geox", 50, 0.2, 0, fedex, 31, "atacadores", "rosa", "2023-03-10");

        // T-Shirts
        Piloto p14 = new Piloto("Johnny Depp", "EUA", 6, 0.6);
        Piloto p15 = new Piloto("Volaré", "Espanha", 2, 0.8);
        Piloto p16 = new Piloto("Carlos Wet Floor", "Alemanha", 4, 1.0);
        Piloto p17 = new Piloto("Odete Peixoto", "Portugal", 4, 0.6);
        Piloto p18 = new Piloto("Olívia Palito", "Inglaterra", 3, 0.8);
        Piloto p19 = new Piloto("Woodie", "EUA", 7, 0.9);
        Piloto p20 = new Piloto("Andy Crescido", "EUA", 8, 0.7);
        Piloto p21 = new Piloto("Bela Adormecida", "Irlanda", 5, 0.3);
        Piloto p22 = new Piloto("Noddy", "Irlanda", 4, 0.5);
        Piloto p23 = new Piloto("Tunning", "Inglaterra", 6, 0.7);
        Piloto p24 = new Piloto("Joseph Tea", "Inglaterra", 7, 0.6);
        Piloto p25 = new Piloto("Marc Porshe", "França", 9, 0.5);
        Piloto p26 = new Piloto("Johnny Azeri", "Azerbeijão", 9, 0.5);

        // Malas
        Piloto p27 = new Piloto("James Dean", "EUA", 9, 0.9);
        Piloto p28 = new Piloto("James Dean Junior", "EUA", 8, 0.9);
        Piloto p29 = new Piloto("Rosa Mota", "Portugal", 7, 0.6);
        Piloto p30 = new Piloto("Rui Carro", "Portugal", 8, 0.3);
        Piloto p31 = new Piloto("Lisa Simpson", "EUA", 3, 0.6);
        Piloto p32 = new Piloto("Bart Simpson", "EUA", 5, 0.8);
        Piloto p33 = new Piloto("Kaname Kuran", "Japão", 5, 0.9);
        Piloto p34 = new Piloto("Yuki Kuran", "Japão", 2, 0.5);
        Piloto p35 = new Piloto("Leon Profession", "Cracóvia", 9, 0.4);
        Piloto p36 = new Piloto("Rose Deluxe", "Cracóvia", 9, 0.3);
        Piloto p37 = new Piloto("Jorge Sampaio", "Portugal", 4, 0.9);
        Piloto p38 = new Piloto("Paulo Portas", "Portugal", 4, 0.9);
        Piloto p39 = new Piloto("Marta Pocinhas", "Brasil", 5, 0.9);

        TreeSet<Utilizador> users = new TreeSet();
        participantes.add(c1);
        participantes.add(c2);
        participantes.add(c3);
        participantes.add(c4);
        participantes.add(c5);
        participantes.add(c6);
        participantes.add(c7);
        participantes.add(c8);
        participantes.add(c9);
        participantes.add(c10);
        participantes.add(c11);
        participantes.add(c12);
        participantes.add(c13);
        participantes.add(c14);
        participantes.add(c15);
        participantes.add(c16);
        participantes.add(c17);
        participantes.add(c18);
        participantes.add(c19);
        participantes.add(c20);
        return participantes;

    }

    public static TreeSet<Carro> loadParticipantesBasicos() {

        Carro c1 = new PC1(1, "Lamborghini", "Tó", 280, eq1, 0);
        Carro c2 = new PC1(2, "Porsche", "Henrique", 250, eq2, 0);
        Carro c3 = new PC1(3, "Ferrari", "Mariana", 350, eq3, 0);
        Carro c4 = new PC1Hibrido(9004, "VolksWagen", "Golf", 260, 160, eq4, 0);
        Carro c5 = new PC1Hibrido(9005, "Porsche", "Ambientalista", 300, 190, eq5, 0);
        Carro c6 = new PC2(6, "Porce", "Chines", 6000, 250, eq6, 0, 0.4);
        Carro c7 = new PC2(7, "Kitt", "Vemibuscar", 4500, 220, eq7, 0, 0.9);
        Carro c8 = new PC2(8, "Delorean", "Grey", 5000, 180, eq8, 0, 0.9);
        Carro c9 = new PC2Hibrido(9009, "Marcada", "Porreira", 4900, 250, 150, eq9, 0, 0.8);
        Carro c10 = new PC2Hibrido(9010, "Mercedes", "Racer", 5000, 290, 130, eq10, 0, 0.9);
        Carro c11 = new PC2Hibrido(9011, "Ford", "Consciente", 5500, 260, 260, eq11, 0, 0.7);
        Carro c12 = new PC2Hibrido(9012, "Ford", "Focado", 5000, 150, 179, eq12, 0, 0.9);
        Carro c13 = new GT(13, "Fiat", "Panda", 3500, 180, eq13, 0);
        Carro c14 = new GT(14, "Fiat", "Punto", 3000, 220, eq14, 0);
        Carro c15 = new GT(15, "Mazda", "Racing", 4500, 230, eq15, 0);
        Carro c16 = new GTHibrido(9016, "Mazda", "Friendly", 4000, 170, 140, eq16, 0);
        Carro c17 = new GTHibrido(9017, "Ford", "NewFriendly", 3800, 220, 170, eq17, 0);
        Carro c18 = new SC(18, "VolksWagen", "Lupo", 180, eq18, 0);
        Carro c19 = new SC(19, "Fiat", "Punto", 120, eq19, 0);
        Carro c20 = new SC(20, "Mazda", "ZZ", 150, eq20, 0);

        TreeSet<Utilizador> users = new TreeSet();
        participantes.add(c1);
        participantes.add(c2);
        participantes.add(c3);
        participantes.add(c4);
        participantes.add(c5);
        participantes.add(c6);
        participantes.add(c7);
        participantes.add(c8);
        participantes.add(c9);
        participantes.add(c10);
        participantes.add(c11);
        participantes.add(c12);
        participantes.add(c13);
        participantes.add(c14);
        participantes.add(c15);
        participantes.add(c16);
        participantes.add(c17);
        participantes.add(c18);
        participantes.add(c19);
        participantes.add(c20);
        return participantes;
    }

    public static Utilizadores loadUtilizadores() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("users.bin"));
        Utilizadores users = (Utilizadores)input.readObject();
        input.close();
        return users;
    }

    public static Campeonato loadSavedGame(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream game = new ObjectInputStream(new FileInputStream(filename + ".bin"));
        int nCamp = (Integer)game.readObject();
        int nCorr = (Integer)game.readObject();
        TreeSet<Carro> parts = (TreeSet)game.readObject();
        ArrayList<Circuito> circs = (ArrayList)game.readObject();
        Classificacao classif = new Classificacao(parts);
        classif.setResultadosCampeonato(parts);
        ArrayList<Utilizador> jogad = (ArrayList)game.readObject();
        HashSet<Utilizador> apostCamp = (HashSet)game.readObject();
        Campeonato novo = new Campeonato(nCamp, circs, nCorr, parts, classif, jogad, apostCamp);
        game.close();
        return novo;
    }

    public static void saveCircuitosB(ArrayList<Circuito> circs1, ArrayList<Circuito> circs2) throws IOException {
        ObjectOutputStream fileParts = new ObjectOutputStream(new FileOutputStream("circuitos.bin", false));
        Iterator var3 = circs1.iterator();

        Circuito aux;
        while(var3.hasNext()) {
            aux = (Circuito)var3.next();
            aux.cleanApostadores();
        }

        var3 = circs2.iterator();

        while(var3.hasNext()) {
            aux = (Circuito)var3.next();
            aux.cleanApostadores();
        }

        fileParts.writeObject(circs1);
        fileParts.writeObject(circs2);
        fileParts.flush();
        fileParts.close();
    }

    public static void saveParticipantesB(TreeSet<Carro> parts) throws IOException {
        Iterator var1 = parts.iterator();

        while(var1.hasNext()) {
            Carro aux = (Carro)var1.next();
            aux.setVoltaDNF(0);
            aux.setTempoCorrida(0.0);
            aux.setPontos(0);
        }

        ObjectOutputStream fileParts = new ObjectOutputStream(new FileOutputStream("participantes.bin", false));
        fileParts.writeObject(parts);
        fileParts.flush();
        fileParts.close();
    }

    public static void saveGame(String filename, int nCamp, ArrayList<Circuito> circs, int nCorr, TreeSet<Carro> parts, Classificacao classif, ArrayList<Utilizador> jogad, HashSet<Utilizador> apostCamp) throws IOException {
        ObjectOutputStream gameA = new ObjectOutputStream(new FileOutputStream(filename + ".bin", false));
        gameA.writeObject(nCamp);
        gameA.writeObject(nCorr);
        gameA.writeObject(parts);
        gameA.writeObject(circs);
        gameA.writeObject(jogad);
        gameA.writeObject(apostCamp);
        gameA.flush();
        gameA.close();
    }

    public static void saveUtilizadores(Utilizadores bdjogadores, ArrayList<Utilizador> cUsers) throws IOException {
        Iterator var2 = cUsers.iterator();

        while(var2.hasNext()) {
            Utilizador utilizador = (Utilizador)var2.next();
            utilizador.cleanApostasActuais();
            bdjogadores.actualiza(utilizador);
        }

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("users.bin", false));
        output.writeObject(bdjogadores);
        output.flush();
        output.close();
    }

}
