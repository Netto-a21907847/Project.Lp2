package pt.ulusofona.lp2.fandeisiaGame;

import java.io.*;
import java.util.*;

public class FandeisiaGameManager {
    static int ROWS;
    static int COLUMNS;
    Team ldr = new Team(10, "LDR");
    Team resistencia = new Team(20, "RESISTENCIA");
    static List<Treasure> listaTreasures;
    static List<Hole> listaHoles;
    static List<Creature> listaCreatures;
    int nrTurnosSemTesouros;
    int nrTurnos;
    static Team equipeAtual;
    List<Spell> listaSpells;
    boolean active = false;

    public FandeisiaGameManager() {
    }

    public void criaListaFeiticos() {
        listaSpells = new ArrayList<>();
        listaSpells.add(new Congela4Ever("Congela4Ever"));
        listaSpells.add(new Congela("Congela"));
        listaSpells.add(new EmpurraParaNorte("EmpurraParaNorte"));
        listaSpells.add(new ReduzAlcance("ReduzAlcance"));
        listaSpells.add(new DuplicaAlcance("DuplicaAlcance"));
        listaSpells.add(new Descongela("Descongela"));
        listaSpells.add(new EmpurraParaOeste("EmpurraParaOeste"));
        listaSpells.add(new EmpurraParaEste("EmpurraParaEste"));
        listaSpells.add(new EmpurraParaSul("EmpurraParaSul"));
    }

    public static void adicionaTesouro(Treasure treasure) {
        listaTreasures.add(treasure);
    }

    public static int somaPontosTesouros() {
        int resultado = 0;
        for (Treasure treasure : listaTreasures) {
            resultado += treasure.getPontos();
        }
        return resultado;
    }

    public static void adicionaBuracos(Hole hole) {
        listaHoles.add(hole);
    }

    public static void adicionaCriaturas(Creature criatura) {
        listaCreatures.add(criatura);
    }

    public static int getROWS() {
        return ROWS;
    }

    public static int getCOLUMNS() {
        return COLUMNS;
    }

    public String[][] getCreatureTypes() {
        String[][] tiposCriaturas = new String[5][4];
        tiposCriaturas[0][0] = "Anão";
        tiposCriaturas[0][1] = "lagarta.png";
        tiposCriaturas[0][2] = "Move H/V - 1 casa.";
        tiposCriaturas[0][3] = "1";
        tiposCriaturas[1][0] = "Dragão";
        tiposCriaturas[1][1] = "gato_de_cheshire.png";
        tiposCriaturas[1][2] = "Move H/V/D - 3 casas - Voa buracos e criaturas.";
        tiposCriaturas[1][3] = "9";
        tiposCriaturas[2][0] = "Elfo";
        tiposCriaturas[2][1] = "chapeleiro_maluco.PNG";
        tiposCriaturas[2][2] = "Move H/V/D - 2 casas - Salta Buracos.";
        tiposCriaturas[2][3] = "5";
        tiposCriaturas[3][0] = "Gigante";
        tiposCriaturas[3][1] = "rainha_de_copas.png";
        tiposCriaturas[3][2] = "Move H/V - 3 casas - Salta buracos e criaturas*.";
        tiposCriaturas[3][3] = "5";
        tiposCriaturas[4][0] = "Humano";
        tiposCriaturas[4][1] = "alice.png";
        tiposCriaturas[4][2] = "Move H/V - 2 casas.";
        tiposCriaturas[4][3] = "3";
        return tiposCriaturas;
    }

    public String[][] getSpellTypes() {
        String[][] tiposFeiticos = new String[9][3];
        tiposFeiticos[0][0] = "EmpurraParaNorte";
        tiposFeiticos[0][1] = "Move a criatura 1 unidade para o Norte";
        tiposFeiticos[0][2] = "1";
        tiposFeiticos[1][0] = "EmpurraParaEste";
        tiposFeiticos[1][1] = "Move a criatura 1 unidade para o Este";
        tiposFeiticos[1][2] = "1";
        tiposFeiticos[2][0] = "EmpurraParaSul";
        tiposFeiticos[2][1] = "Move a criatura 1 unidade para o Sul";
        tiposFeiticos[2][2] = "1";
        tiposFeiticos[3][0] = "EmpurraParaOeste";
        tiposFeiticos[3][1] = "Move a criatura 1 unidade para o Oeste";
        tiposFeiticos[3][2] = "1";
        tiposFeiticos[4][0] = "ReduzAlcance";
        tiposFeiticos[4][1] = "Reduz o alcance da criatura para: MIN (alcance original,1)";
        tiposFeiticos[4][2] = "2";
        tiposFeiticos[5][0] = "DuplicaAlcance";
        tiposFeiticos[5][1] = "Aumenta o alcance da criatura para o dobro";
        tiposFeiticos[5][2] = "3";
        tiposFeiticos[6][0] = "Congela";
        tiposFeiticos[6][1] = "A criatura alvo não se move neste turno";
        tiposFeiticos[6][2] = "3";
        tiposFeiticos[7][0] = "Congela4Ever";
        tiposFeiticos[7][1] = "A criatura alvo não se move mais até ao final do jogo";
        tiposFeiticos[7][2] = "10";
        tiposFeiticos[8][0] = "Descongela";
        tiposFeiticos[8][1] = "Inverte a aplicação de um Feitiço Congela4Ever";
        tiposFeiticos[8][2] = "8";
        return tiposFeiticos;
    }

    public void toggleAI(boolean active) {
        active = !active;
    }

    public Map<String, Integer> createComputerArmy() {
        int plafondInicial = 50;
        int custosCriaturasTotal = 0;
        Map<String, Integer> criaturasInimigo;
        do {
            criaturasInimigo = new HashMap<>();
            int geraQtdCriatura = (int) (Math.random() * 4);
            if (geraQtdCriatura > 0) {
                criaturasInimigo.put("Anão", geraQtdCriatura);
                custosCriaturasTotal += geraQtdCriatura;
            }
            geraQtdCriatura = (int) (Math.random() * 4);
            if (geraQtdCriatura > 0) {
                criaturasInimigo.put("Dragão", geraQtdCriatura);
                custosCriaturasTotal += geraQtdCriatura * 9;
            }
            geraQtdCriatura = (int) (Math.random() * 4);
            if (geraQtdCriatura > 0) {
                criaturasInimigo.put("Humano", geraQtdCriatura);
                custosCriaturasTotal += geraQtdCriatura * 3;
            }
            geraQtdCriatura = (int) (Math.random() * 4);
            if (geraQtdCriatura > 0) {
                criaturasInimigo.put("Gigante", geraQtdCriatura);
                custosCriaturasTotal += geraQtdCriatura * 5;
            }
            geraQtdCriatura = (int) (Math.random() * 4);
            if (geraQtdCriatura > 0) {
                criaturasInimigo.put("Elfo", geraQtdCriatura);
                custosCriaturasTotal += geraQtdCriatura * 5;
            }
        } while (custosCriaturasTotal > plafondInicial || criaturasInimigo.isEmpty());
        return criaturasInimigo;
    }

    public void startGame(String[] content, int rows, int columns) throws InsufficientCoinsException {
        ldr = new Team(10, "LDR");
        resistencia = new Team(20, "RESISTENCIA");
        nrTurnosSemTesouros = 0;
        nrTurnos = 0;
        listaTreasures = new ArrayList<>();
        listaHoles = new ArrayList<>();
        listaCreatures = new ArrayList<>();
        ROWS = rows;
        COLUMNS = columns;
        criaListaFeiticos();
        equipeAtual = defineEquipeInicial();
        for (String conteudoInserido : content) {
            String[] dadosDoItem = conteudoInserido.split(",");
            if (!dadosDoItem[1].contains("gold") && !dadosDoItem[1].contains("silver") && !dadosDoItem[1].contains("bronze")
                    && !dadosDoItem[1].contains("hole") && !dadosDoItem[1].contains("Anão") && !dadosDoItem[1].contains("Dragão")
                    && !dadosDoItem[1].contains("Elfo") && !dadosDoItem[1].contains("Gigante") && !dadosDoItem[1].contains("Humano")) {
                continue;
            }
            if (dadosDoItem[1].contains("gold") || dadosDoItem[1].contains("silver") || dadosDoItem[1].contains("bronze")) {
                String idTesouro = dadosDoItem[0].replace("id: ", "").trim();
                String tipoTesouro = dadosDoItem[1].replace("type: ", "").trim();
                String x = dadosDoItem[2].replace("x: ", "").trim();
                String y = dadosDoItem[3].replace("y: ", "").trim();
                Treasure treasure = new Treasure(Integer.parseInt(idTesouro), tipoTesouro, Integer.parseInt(x), Integer.parseInt(y));
                adicionaTesouro(treasure); // TESOURO - id: <id>, type: gold/silver/bronze, x:<x>, y: <y>
            } else if (dadosDoItem[1].contains("hole")) {
                String idBuraco = dadosDoItem[0].replace("id: ", "").trim();
                String x = dadosDoItem[2].replace("x: ", "").trim();
                String y = dadosDoItem[3].replace("y: ", "").trim();
                Hole hole = new Hole(Integer.parseInt(idBuraco), Integer.parseInt(x), Integer.parseInt(y));
                adicionaBuracos(hole); // BURACO - id: <id>, type: hole, x:<x>, y: <y>
            } else {
                String idCriatura = dadosDoItem[0].replace("id: ", "").trim();
                String tipo = dadosDoItem[1].replace("type: ", "").trim();
                String teamId = dadosDoItem[2].replace("teamId: ", "").trim();
                String x = dadosDoItem[3].replace("x: ", "").trim();
                String y = dadosDoItem[4].replace("y: ", "").trim();
                String orientacao = dadosDoItem[5].replace("orientation: ", "").trim();
                switch (tipo) { // CREATURE - id: <id>, type: <type>, teamId: <teamId>, x: <x>, y: <y>, orientation: <orientation>
                    case "Anão":
                        Creature anao = new Anao(Integer.parseInt(idCriatura), tipo, Integer.parseInt(teamId), Integer.parseInt(x), Integer.parseInt(y), orientacao);
                        if (teamId.equals("10")) {
                            anao.teamCriatura = ldr;
                        } else {
                            anao.teamCriatura = resistencia;
                        }
                        adicionaCriaturas(anao);
                        anao.getTeamCriatura().removerMoedas(anao.getCusto());
                        break;
                    case "Dragão":
                        Creature dragao = new Dragao(Integer.parseInt(idCriatura), tipo, Integer.parseInt(teamId), Integer.parseInt(x), Integer.parseInt(y), orientacao);
                        if (teamId.equals("10")) {
                            dragao.teamCriatura = ldr;
                        } else {
                            dragao.teamCriatura = resistencia;
                        }
                        adicionaCriaturas(dragao);
                        dragao.getTeamCriatura().removerMoedas(dragao.getCusto());
                        break;
                    case "Elfo":
                        Creature elfo = new Elfo(Integer.parseInt(idCriatura), tipo, Integer.parseInt(teamId), Integer.parseInt(x), Integer.parseInt(y), orientacao);
                        if (teamId.equals("10")) {
                            elfo.teamCriatura = ldr;
                        } else {
                            elfo.teamCriatura = resistencia;
                        }
                        adicionaCriaturas(elfo);
                        elfo.getTeamCriatura().removerMoedas(elfo.getCusto());
                        break;
                    case "Gigante":
                        Creature gigante = new Gigante(Integer.parseInt(idCriatura), tipo, Integer.parseInt(teamId), Integer.parseInt(x), Integer.parseInt(y), orientacao);
                        if (teamId.equals("10")) {
                            gigante.teamCriatura = ldr;
                        } else {
                            gigante.teamCriatura = resistencia;
                        }
                        adicionaCriaturas(gigante);
                        gigante.getTeamCriatura().removerMoedas(gigante.getCusto());
                        break;
                    case "Humano":
                        Creature humano = new Humano(Integer.parseInt(idCriatura), tipo, Integer.parseInt(teamId), Integer.parseInt(x), Integer.parseInt(y), orientacao);
                        if (teamId.equals("10")) {
                            humano.teamCriatura = ldr;
                        } else {
                            humano.teamCriatura = resistencia;
                        }
                        adicionaCriaturas(humano);
                        humano.getTeamCriatura().removerMoedas(humano.getCusto());
                        break;
                }
            }
        }
        listaCreatures.sort(Comparator.comparingInt(Mapa::getId)); // organiza a lista
        if (ldr.getMoedasEquipe() < 0 && resistencia.getMoedasEquipe() >= 0) {
            throw new InsufficientCoinsException("Ldr excedeu o plafond!", ldr.getMoedasEquipe(), resistencia.getMoedasEquipe());
        }
        if (ldr.getMoedasEquipe() >= 0 && resistencia.getMoedasEquipe() < 0) {
            throw new InsufficientCoinsException("Resistencia excedeu o plafond!", ldr.getMoedasEquipe(), resistencia.getMoedasEquipe());
        }
        if (ldr.getMoedasEquipe() < 0 && resistencia.getMoedasEquipe() < 0) {
            throw new InsufficientCoinsException("Ambas equipes excederam o plafond!", ldr.getMoedasEquipe(), resistencia.getMoedasEquipe());
        }
    }

    public void setInitialTeam(int teamId) {
        if (teamId == ldr.getIdEquipe()) {
            equipeAtual = ldr;
        } else {
            equipeAtual = resistencia;
        }
    }

    public boolean enchantComputer() {
        int aplicaraFeitico = (int) (Math.random() * 2);
        if (aplicaraFeitico == 1) {
            int nrTotalCriatura = listaCreatures.size();
            int posicaoCriatura = (int) (Math.random() * nrTotalCriatura);
            int feiticoEscolhido = (int) (Math.random() * 9) + 1;
            int xCriaturaSorteada = listaCreatures.get(posicaoCriatura).getX();
            int yCriaturaSorteada = listaCreatures.get(posicaoCriatura).getY();
            String feiticoRandom = "";
            for (Spell feitico : listaSpells) {
                if (feitico.getIdFeitico() == feiticoEscolhido) {
                    feiticoRandom = feitico.getNomeFeitico();
                }
            }
            return enchant(xCriaturaSorteada, yCriaturaSorteada, feiticoRandom);
        }
        return false;
    }

    public boolean enchant(int x, int y, String spellName) {
        if (confereContemCreature(x, y)) {
            getCriaturaPorPosicao(x, y).nrFeiticosSofrido++;
            for (Spell feitico : listaSpells) {
                if (feitico.getNomeFeitico().equals(spellName)) {
                    return feitico.aplicaFeitico(getCriaturaPorPosicao(x, y));
                }
            }
        }
        return false;
    }

    public void processTurn() {
        int ptsLdrBeforeTurn = ldr.getPontosEquipe();
        int ptsResBeforeTurn = resistencia.getPontosEquipe();
        int nrTesouros = listaTreasures.size();
        if (active && equipeAtual.getIdEquipe() == 20) {
            enchantComputer();
        }
        for (Creature criaturaAtiva : listaCreatures) {
            if (criaturaAtiva.temSpell) {
                switch (criaturaAtiva.getSpellName()) {
                    case "Congela":
                        criaturaAtiva.temSpell = false;
                        continue;
                    case "ReduzAlcance":
                        criaturaAtiva.reduzAlcance_moveCriatura();
                        criaturaAtiva.temSpell = false;
                        continue;
                    case "DuplicaAlcance":
                        criaturaAtiva.duplicaAlcance();
                        criaturaAtiva.temSpell = false;
                        continue;
                    case "Descongela":
                        criaturaAtiva.estaCongelado = false;
                        criaturaAtiva.moveCriatura();
                        criaturaAtiva.temSpell = false;
                        continue;
                    case "Congela4Ever":
                        criaturaAtiva.estaCongelado = true;
                        criaturaAtiva.temSpell = false;
                        continue;
                    case "EmpurraParaEste":
                        if (!confereContemCreature(criaturaAtiva.getX() + 1, criaturaAtiva.getY())) {
                            criaturaAtiva.x++;
                            criaturaAtiva.kmPercorrido++;
                            criaturaAtiva.confereContemTesouro(criaturaAtiva, criaturaAtiva.getX(), criaturaAtiva.getY());
                            criaturaAtiva.moveCriatura();
                        } else {
                            criaturaAtiva.moveCriatura();
                        }
                        criaturaAtiva.temSpell = false;
                        continue;
                    case "EmpurraParaOeste":
                        if (!confereContemCreature(criaturaAtiva.getX() - 1, criaturaAtiva.getY())) {
                            criaturaAtiva.x -= 1;
                            criaturaAtiva.kmPercorrido++;
                            criaturaAtiva.confereContemTesouro(criaturaAtiva, criaturaAtiva.getX(), criaturaAtiva.getY());
                            criaturaAtiva.moveCriatura();
                        } else {
                            criaturaAtiva.moveCriatura();
                        }
                        criaturaAtiva.temSpell = false;
                        continue;
                    case "EmpurraParaNorte":
                        if (!confereContemCreature(criaturaAtiva.getX(), criaturaAtiva.getY() - 1)) {
                            criaturaAtiva.y--;
                            criaturaAtiva.kmPercorrido++;
                            criaturaAtiva.confereContemTesouro(criaturaAtiva, criaturaAtiva.getX(), criaturaAtiva.getY());
                            criaturaAtiva.moveCriatura();
                        } else {
                            criaturaAtiva.moveCriatura();
                        }
                        criaturaAtiva.temSpell = false;
                        continue;
                    case "EmpurraParaSul":
                        if (!confereContemCreature(criaturaAtiva.getX(), criaturaAtiva.getY() + 1)) {
                            criaturaAtiva.y++;
                            criaturaAtiva.kmPercorrido++;
                            criaturaAtiva.confereContemTesouro(criaturaAtiva, criaturaAtiva.getX(), criaturaAtiva.getY());
                            criaturaAtiva.moveCriatura();
                        } else {
                            criaturaAtiva.moveCriatura();
                        }
                        criaturaAtiva.temSpell = false;
                }
            } else {
                criaturaAtiva.moveCriatura();
            }
        }
        if (equipeAtual.getIdEquipe() == 10) {
            equipeAtual = resistencia;
        } else {
            equipeAtual = ldr;
        }
        if (nrTesouros == listaTreasures.size()) {
            nrTurnosSemTesouros++;
        } else {
            nrTurnosSemTesouros = 0;
        }
        coinsAfterTurn(ptsLdrBeforeTurn, ptsResBeforeTurn);
        nrTurnos++;
    }

    public List<Creature> getCreatures() {
        return listaCreatures;
    }

    public boolean gameIsOver() {
        int qtGoldNomundo = 0;
        for (Treasure tesouros : listaTreasures){
            if (tesouros.getTipoTesouro().equals("gold")){
                qtGoldNomundo++;
            }
        }

        if (qtGoldNomundo == 1){
            return true;
        }

        if (listaTreasures.size() == 0) {
            return true;
        }

        if (nrTurnosSemTesouros == 15) {
            return true;
        }

        return ldr.getPontosEquipe() > resistencia.getPontosEquipe() + somaPontosTesouros() || resistencia.getPontosEquipe() > ldr.getPontosEquipe() + somaPontosTesouros();
    }

    public List<String> getAuthors() {
        List<String> autores = new ArrayList<>();
        autores.add("Netto Baptistella - A21907847");
        return autores;
    }

    public List<String> getResults() {
        List<String> results = new ArrayList<>();
        if (gameIsOver()) {
            if (ldr.getPontosEquipe() == resistencia.getPontosEquipe()) {
                results.add("Welcome to FANDEISIA");
                results.add("Resultado: EMPATE");
                results.add("LDR: " + ldr.getPontosEquipe());
                results.add("RESISTENCIA: " + resistencia.getPontosEquipe());
                results.add("Nr. de Turnos jogados: " + nrTurnos);
                results.add("-----");
                for (Creature criatura : listaCreatures) {
                    results.add(criatura.getId() + " : " + criatura.getTipo() + " : " + criatura.getGoldQtd() +
                            " : " + criatura.getSilverQtd() + " : " + criatura.getBronzeQtd() + " : " + criatura.getNrPontos());
                }
                return results;
            }
            Team winner;
            Team looser;
            if (ldr.getPontosEquipe() > resistencia.getPontosEquipe()) {
                winner = ldr;
                looser = resistencia;
            } else {
                winner = resistencia;
                looser = ldr;
            }
            results.add("Welcome to FANDEISIA");
            results.add("Resultado: Vitória da equipa " + winner.getNomeEquipe());
            results.add(winner.getNomeEquipe() + ": " + winner.getPontosEquipe());
            results.add(looser.getNomeEquipe() + ": " + looser.getPontosEquipe());
            results.add("Nr. de Turnos jogados: " + nrTurnos);
            results.add("-----");
            for (Creature criatura : listaCreatures) {
                results.add(criatura.getId() + " : " + criatura.getTipo() + " : " + criatura.getGoldQtd() +
                        " : " + criatura.getSilverQtd() + " : " + criatura.getBronzeQtd() + " : " + criatura.getNrPontos());
            }
            return results;
        }
        return results;
    }

    public int getElementId(int x, int y) {
        for (Creature criaturas : listaCreatures) {
            if (criaturas.getX() == x && criaturas.getY() == y) {
                return criaturas.getId();
            }
        }
        for (Treasure tesouros : listaTreasures) {
            if (tesouros.getX() == x && tesouros.getY() == y) {
                return tesouros.getId();
            }
        }
        for (Hole buracos : listaHoles) {
            if (buracos.getX() == x && buracos.getY() == y) {
                return buracos.getId();
            }
        }
        return 0;
    }

    public int getCurrentTeamId() {
        return equipeAtual.getIdEquipe();
    }

    public int getCurrentScore(int teamID) {
        return getTeam(teamID).getPontosEquipe();
    }

    public String getSpell(int x, int y) {
        for (Creature criatura : listaCreatures) {
            if (criatura.getX() == x && criatura.getY() == y) {
                if (criatura.temSpell) {
                    return criatura.getSpellName();
                }
            }
        }
        return null;
    }

    public int getCoinTotal(int teamID) {
        return getTeam(teamID).getMoedasEquipe();
    }

    public boolean saveGame(File fich) {
        List<String> dadosGame = new ArrayList<>();
        dadosGame.add("info," + nrTurnos + "," + nrTurnosSemTesouros + "," + equipeAtual.getIdEquipe() + "," + ROWS + "," + COLUMNS);
        dadosGame.add("team," + ldr.getIdEquipe() + "," + ldr.getPontosEquipe() + "," + ldr.getMoedasEquipe());
        dadosGame.add("team," + resistencia.getIdEquipe() + "," + resistencia.getPontosEquipe() + "," + resistencia.getMoedasEquipe());
        for (Hole buraco : listaHoles) {
            dadosGame.add("hole," + buraco.getId() + "," + buraco.getX() + "," + buraco.getY());
        }
        for (Treasure tesouro : listaTreasures) {
            dadosGame.add("treasure," + tesouro.getId() + "," + tesouro.getTipoTesouro() + "," + tesouro.getX() + "," + tesouro.getY());
        }
        for (Creature criatura : listaCreatures) {
            dadosGame.add("creature," + criatura.getId() + "," + criatura.getTipo() + "," + criatura.getIdEquipe() + "," + criatura.getX() + "," + criatura.getY()
                    + "," + criatura.getOrientacao() + "," + criatura.getNrTesouros() + "," + criatura.getGoldQtd() + "," + criatura.getSilverQtd() + "," +
                    criatura.getBronzeQtd() + "," + criatura.getEstaCongelado() + "," + criatura.getTemSpell());
        }
        try (FileWriter escreveFicheiro = new FileWriter(fich);
             BufferedWriter writer = new BufferedWriter(escreveFicheiro)) {
            for (String dados : dadosGame) {
                writer.append(dados).append("\n");
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean loadGame(File fich) {
        try {
            BufferedReader lerFicheiro = new BufferedReader(new FileReader(fich));
            String linha;
            listaCreatures = new ArrayList<>();
            listaTreasures = new ArrayList<>();
            listaHoles = new ArrayList<>();
            criaListaFeiticos();
            ldr = new Team(10, "LDR");
            resistencia = new Team(20, "RESISTENCIA");
            while ((linha = lerFicheiro.readLine()) != null) {
                String[] campo = linha.split(",");
                if (campo[0].equals("info")) {
                    String lNrTurnos = campo[1];
                    String lNrTurnosSemTesouros = campo[2];
                    String lIdEquipeAtual = campo[3];
                    String lRows = campo[4];
                    String lColumns = campo[5];
                    nrTurnos = Integer.parseInt(lNrTurnos);
                    nrTurnosSemTesouros = Integer.parseInt(lNrTurnosSemTesouros);
                    ROWS = Integer.parseInt(lRows);
                    COLUMNS = Integer.parseInt(lColumns);
                    equipeAtual = getTeam(Integer.parseInt(lIdEquipeAtual));
                    continue;
                }
                if (campo[0].equals("team")) {
                    String lIdEquipe = campo[1];
                    String lPontosEquipe = campo[2];
                    String lMoedasEquipe = campo[3];
                    if (Integer.parseInt(lIdEquipe) == 10) {
                        ldr.setMoedasEquipe(Integer.parseInt(lMoedasEquipe));
                        ldr.setPontosEquipe(Integer.parseInt(lPontosEquipe));
                    } else if (Integer.parseInt(lIdEquipe) == 20) {
                        resistencia.setMoedasEquipe(Integer.parseInt(lMoedasEquipe));
                        resistencia.setPontosEquipe(Integer.parseInt(lPontosEquipe));
                    }
                    continue;
                }
                if (campo[0].equals("hole")) {
                    String lIdBuraco = campo[1];
                    String lx = campo[2];
                    String ly = campo[3];
                    Hole buraco = new Hole(Integer.parseInt(lIdBuraco), Integer.parseInt(lx), Integer.parseInt(ly));
                    listaHoles.add(buraco);
                    continue;
                }
                if (campo[0].equals("treasure")) {
                    String lIdTesouro = campo[1];
                    String lTipoTesouro = campo[2];
                    String lx = campo[3];
                    String ly = campo[4];
                    Treasure tesouro = new Treasure(Integer.parseInt(lIdTesouro), lTipoTesouro, Integer.parseInt(lx), Integer.parseInt(ly));
                    listaTreasures.add(tesouro);
                    continue;
                }
                if (campo[0].equals("creature")) {
                    String lCriaturaId = campo[1];
                    String lCriaturaTipo = campo[2];
                    String lCriaturaIdEquipe = campo[3];
                    String lx = campo[4];
                    String ly = campo[5];
                    String lOrientacao = campo[6];
                    String lnrPontos = campo[7];
                    String lgold = campo[8];
                    String lsilver = campo[9];
                    String lbronze = campo[10];
                    String lestaCongelada = campo[11];
                    String lTemSpell = campo[12];
                    switch (lCriaturaTipo) {
                        case "Anão":
                            Creature c = new Anao(Integer.parseInt(lCriaturaId), lCriaturaTipo, Integer.parseInt(lCriaturaIdEquipe),
                                    Integer.parseInt(lx), Integer.parseInt(ly), lOrientacao);
                            if (lCriaturaIdEquipe.equals("10")) {
                                c.teamCriatura = ldr;
                            } else {
                                c.teamCriatura = resistencia;
                            }
                            c.nrTesouros = Integer.parseInt(lnrPontos);
                            c.goldQtd = Integer.parseInt(lgold);
                            c.silverQtd = Integer.parseInt(lsilver);
                            c.bronzeQtd = Integer.parseInt(lbronze);
                            if (lestaCongelada.equals("true")) {
                                c.estaCongelado = true;
                            }
                            if (lTemSpell.equals("true")) {
                                c.temSpell = true;
                            }
                            listaCreatures.add(c);
                            break;
                        case "Humano":
                            Creature h = new Humano(Integer.parseInt(lCriaturaId), lCriaturaTipo, Integer.parseInt(lCriaturaIdEquipe),
                                    Integer.parseInt(lx), Integer.parseInt(ly), lOrientacao);
                            if (lCriaturaIdEquipe.equals("10")) {
                                h.teamCriatura = ldr;
                            } else {
                                h.teamCriatura = resistencia;
                            }
                            h.nrTesouros = Integer.parseInt(lnrPontos);
                            h.goldQtd = Integer.parseInt(lgold);
                            h.silverQtd = Integer.parseInt(lsilver);
                            h.bronzeQtd = Integer.parseInt(lbronze);
                            if (lestaCongelada.equals("true")) {
                                h.estaCongelado = true;
                            }
                            if (lTemSpell.equals("true")) {
                                h.temSpell = true;
                            }
                            listaCreatures.add(h);
                            break;
                        case "Gigante":
                            Creature g = new Gigante(Integer.parseInt(lCriaturaId), lCriaturaTipo, Integer.parseInt(lCriaturaIdEquipe),
                                    Integer.parseInt(lx), Integer.parseInt(ly), lOrientacao);
                            if (lCriaturaIdEquipe.equals("10")) {
                                g.teamCriatura = ldr;
                            } else {
                                g.teamCriatura = resistencia;
                            }
                            g.nrTesouros = Integer.parseInt(lnrPontos);
                            g.goldQtd = Integer.parseInt(lgold);
                            g.silverQtd = Integer.parseInt(lsilver);
                            g.bronzeQtd = Integer.parseInt(lbronze);
                            if (lestaCongelada.equals("true")) {
                                g.estaCongelado = true;
                            }
                            if (lTemSpell.equals("true")) {
                                g.temSpell = true;
                            }
                            listaCreatures.add(g);
                            break;
                        case "Elfo":
                            Creature e = new Elfo(Integer.parseInt(lCriaturaId), lCriaturaTipo, Integer.parseInt(lCriaturaIdEquipe),
                                    Integer.parseInt(lx), Integer.parseInt(ly), lOrientacao);
                            if (lCriaturaIdEquipe.equals("10")) {
                                e.teamCriatura = ldr;
                            } else {
                                e.teamCriatura = resistencia;
                            }
                            e.nrTesouros = Integer.parseInt(lnrPontos);
                            e.goldQtd = Integer.parseInt(lgold);
                            e.silverQtd = Integer.parseInt(lsilver);
                            e.bronzeQtd = Integer.parseInt(lbronze);
                            if (lestaCongelada.equals("true")) {
                                e.estaCongelado = true;
                            }
                            if (lTemSpell.equals("true")) {
                                e.temSpell = true;
                            }
                            listaCreatures.add(e);
                            break;
                        case "Dragão":
                            Creature d = new Dragao(Integer.parseInt(lCriaturaId), lCriaturaTipo, Integer.parseInt(lCriaturaIdEquipe),
                                    Integer.parseInt(lx), Integer.parseInt(ly), lOrientacao);
                            if (lCriaturaIdEquipe.equals("10")) {
                                d.teamCriatura = ldr;
                            } else {
                                d.teamCriatura = resistencia;
                            }
                            d.nrTesouros = Integer.parseInt(lnrPontos);
                            d.goldQtd = Integer.parseInt(lgold);
                            d.silverQtd = Integer.parseInt(lsilver);
                            d.bronzeQtd = Integer.parseInt(lbronze);
                            if (lestaCongelada.equals("true")) {
                                d.estaCongelado = true;
                            }
                            if (lTemSpell.equals("true")) {
                                d.temSpell = true;
                            }
                            listaCreatures.add(d);
                            break;
                    }
                }
            }
            lerFicheiro.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public String whoIsLordEder() {
        return "Ederzito António Macedo Lopes";
    }

    public Team defineEquipeInicial() {
        int numeroAleatorio = (int) (Math.random() * 2);
        if (numeroAleatorio == 0) {
            return ldr;
        } else {
            return resistencia;
        }
    }

    public Team getTeam(int teamId) {
        if (teamId == 10) {
            return ldr;
        } else {
            return resistencia;
        }
    }

    public void coinsAfterTurn(int ptsLdrBT, int ptsResBT) {
        if (listaCreatures.size() > 0) {
            int countCriaturasEquipeLdr = 0;
            int countCriaturasEquipeResidencia = 0;
            for (Creature criatura : listaCreatures) {
                if (criatura.getIdEquipe() == 10) {
                    countCriaturasEquipeLdr++;
                } else {
                    countCriaturasEquipeResidencia++;
                }
            }
            if (countCriaturasEquipeLdr > 0) {
                if (ptsLdrBT == ldr.getPontosEquipe()) {
                    ldr.adicionarMoedas(1);
                } else {
                    ldr.adicionarMoedas(2);
                }
            }
            if (countCriaturasEquipeResidencia > 0) {
                if (ptsResBT == resistencia.getPontosEquipe()) {
                    resistencia.adicionarMoedas(1);
                } else {
                    resistencia.adicionarMoedas(2);
                }
            }
        }

    }

    public static Creature getCriaturaPorPosicao(int x, int y) {
        for (Creature criatura : listaCreatures) {
            if (criatura.getX() == x && criatura.getY() == y) {
                return criatura;
            }
        }
        return null;
    }

    public static boolean confereContemCreature(int xNext, int yNext) {
        for (Creature criaturaPosicao : listaCreatures) {
            if (criaturaPosicao.getX() == xNext && criaturaPosicao.getY() == yNext) {
                return true;
            }
        }
        return false;
    }

    public static boolean confereContemBuraco(int xNext, int yNext) {
        for (Hole hole : listaHoles) {
            if (hole.getX() == xNext && hole.getY() == yNext) {
                return true;
            }
        }
        return false;
    }

    public static boolean confereContemGigante(int xNext, int yNext) {
        for (Creature criatura : listaCreatures) {
            if (criatura.getX() == xNext && criatura.getY() == yNext) {
                if (criatura.getTipo().equals("Gigante")) {
                    return true;
                }
            }
        }
        return false;
    }

    public Map<String, List<String>> getStatistics() {
        Map<String, List<String>> results = new HashMap<>();

        List<String> as3MaisCarregadas = new ArrayList<>();
        listaCreatures.stream()
                .sorted((c1, c2) -> c2.getNrTesouros() - c1.getNrTesouros())
                .limit(3)
                .forEach((c) -> as3MaisCarregadas.add(c.getId() + ":" + c.getNrTesouros()));
        results.put("as3MaisCarregadas", as3MaisCarregadas);

        List<String> as5MaisRicas = new ArrayList<>();
        if (listaCreatures.size() > 4) {
            listaCreatures.stream()
                    .sorted(Comparator.comparingInt(Creature::getNrTesouros))
                    .sorted((c1, c2) -> c2.getNrPontos() - c1.getNrPontos())
                    .limit(5)
                    .forEach((c) -> as5MaisRicas.add(c.getId() + ":" + c.getNrPontos() + ":" + c.getNrTesouros()));
        } else {
            listaCreatures.stream()
                    .sorted(Comparator.comparingInt(Creature::getNrTesouros))
                    .sorted((c1, c2) -> c2.getNrPontos() - c1.getNrPontos())
                    .forEach((c) -> as5MaisRicas.add(c.getId() + ":" + c.getNrPontos() + ":" + c.getNrTesouros()));
        }
        results.put("as5MaisRicas", as5MaisRicas);
        List<String> osAlvosFavoritos = new ArrayList<>();
        listaCreatures.stream()
                .sorted((c1, c2) -> c2.getNrFeiticosSofrido() - c1.getNrFeiticosSofrido())
                .limit(3)
                .forEach((c) -> osAlvosFavoritos.add(c.getId() + ":" + c.getIdEquipe() + ":" + c.getNrFeiticosSofrido()));
        results.put("osAlvosFavoritos", osAlvosFavoritos);
        List<String> as3MaisViajadas = new ArrayList<>();
        listaCreatures.stream()
                .sorted((c1, c2) -> c2.getKmPercorrido() - c1.getKmPercorrido())
                .limit(3)
                .sorted(Comparator.comparingInt(Creature::getKmPercorrido))
                .forEach((c) -> as3MaisViajadas.add(c.getId() + ":" + c.getKmPercorrido()));
        results.put("as3MaisViajadas", as3MaisViajadas);
        List<String> tiposDeCriaturaESeusTesouros = new ArrayList<>();
        List<ResultsCreature> listResults = new ArrayList<>();
        int anaoPts;
        int dragaoPts;
        int elfoPts;
        int gigantePts;
        int humanoPts;
        long anaoQtd;
        long dragaoQtd;
        long elfoQtd;
        long giganteQtd;
        long humanoQtd;
        anaoQtd = listaCreatures.stream()
                .filter((c) -> c.getTipo().equals("Anão")).count();
        anaoPts = listaCreatures.stream()
                .filter((c) -> c.getTipo().equals("Anão"))
                .map(Creature::getNrTesouros).mapToInt(Integer::intValue).sum();
        dragaoQtd = listaCreatures.stream()
                .filter((c) -> c.getTipo().equals("Dragão")).count();
        dragaoPts = listaCreatures.stream()
                .filter((c) -> c.getTipo().equals("Dragão"))
                .map(Creature::getNrTesouros).mapToInt(Integer::intValue).sum();
        elfoQtd = listaCreatures.stream()
                .filter((c) -> c.getTipo().equals("Elfo")).count();
        elfoPts = listaCreatures.stream()
                .filter((c) -> c.getTipo().equals("Elfo"))
                .map(Creature::getNrTesouros).mapToInt(Integer::intValue).sum();
        giganteQtd = listaCreatures.stream()
                .filter((c) -> c.getTipo().equals("Gigante")).count();
        gigantePts = listaCreatures.stream()
                .filter((c) -> c.getTipo().equals("Gigante"))
                .map(Creature::getNrTesouros).mapToInt(Integer::intValue).sum();
        humanoQtd = listaCreatures.stream()
                .filter((c) -> c.getTipo().equals("Humano")).count();
        humanoPts = listaCreatures.stream()
                .filter((c) -> c.getTipo().equals("Humano"))
                .map(Creature::getNrTesouros).mapToInt(Integer::intValue).sum();
        if (anaoQtd > 0) {
            listResults.add(new ResultsCreature("Anão", anaoQtd, anaoPts));
        } else {
            listResults.add(new ResultsCreature("Anão", 0, -1));
        }
        if (dragaoQtd > 0) {
            listResults.add(new ResultsCreature("Dragão", dragaoQtd, dragaoPts));
        } else {
            listResults.add(new ResultsCreature("Dragão", 0, -1));
        }
        if (elfoQtd > 0) {
            listResults.add(new ResultsCreature("Elfo", elfoQtd, elfoPts));
        } else {
            listResults.add(new ResultsCreature("Elfo", 0, -1));
        }
        if (giganteQtd > 0) {
            listResults.add(new ResultsCreature("Gigante", giganteQtd, gigantePts));
        } else {
            listResults.add(new ResultsCreature("Gigante", 0, -1));
        }
        if (humanoQtd > 0) {
            listResults.add(new ResultsCreature("Humano", humanoQtd, humanoPts));
        } else {
            listResults.add(new ResultsCreature("Humano", 0, -1));
        }
        listResults.stream()
                .sorted(Comparator.comparingInt(r -> (int) r.getQtTipo()))
                .sorted((r1, r2) -> r2.getPontos() - r1.getPontos())
                .forEach((r) -> tiposDeCriaturaESeusTesouros.add(r.getTipo() + ":" + r.getQtTipo() + ":" + r.getPontos()));
        results.put("tiposDeCriaturaESeusTesouros", tiposDeCriaturaESeusTesouros);
        return results;
    }
}
