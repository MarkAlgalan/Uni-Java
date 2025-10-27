package com.mycompany.juego;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
public class InterfazGrafica extends Juego {
        String[] preguntaPlanetas = {"¿Distancia desde la tierra?(km)"," ¿Tiempo de traslación(años y dias)?"," ¿Tipo de planeta?","¿Temperatura mínima?(C°)"};
        String[] preguntaEstrellas = {"¿A que constelación pertenece? ","¿Distancia en años luz desde la tierra?","¿Tipo de estrella?","¿Luminosidad?(soles)"};
        String[] preguntaNebulosas = {"¿Año de descubrimiento?","¿Constelación a al que pertenece?"};
    //Variables nuevas
    static int Paginas;
   int numeroEstrellas=10;
    int numeroPlanetas=7;
 int numeroNebulosas=7;
    //Fin de las variables nuevas
 boolean noCambio = false;
    boolean[] preguntasUsadas = new boolean[4];    
    static int puntuacionJ1 = 0;
    static int puntuacionJ2 = 0;
    String nombre;
    String tipo;
    String constelacion;
    int tempMin;
    long distanciaTierra;
    boolean usado;
    int contador=0;
    static int tam[]={10,7,7};
    //variable para selección del jugador
    static int x;
    static String nombreU[]= new String[2];
    static int puntuacion[]= {0,0};
    //Contador para la cantidad de preguntas que han pasado
    static int cont[] = {0,0,0};
    boolean respondioMal1 = false;
    boolean respondioMal2 = false;
    boolean seleccionTurno = false;
    int seleccionTurnoImpar = 0;
    int modulo = 0;
    int respondieronMal = 0;
    
        
        
        // metodos setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }
    public void setDistanciaTierra(long distanciaTierra) {
        this.distanciaTierra = distanciaTierra;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setConstelacion(String constelacion) {
        this.constelacion = constelacion;
    }
    // metodos getter
    public String getConstelacion() {
        return constelacion;
    }
    public long getDistanciaTierra() {
        return distanciaTierra;
    }
    public String getNombre() {
        return nombre;
    }
    public int getTempMin() {
        return tempMin;
    }
    public String getTipo() {
        return tipo;
    }
        
        static int turno = 0;
        int contadorPregunta = 0;
        int contadorTurno = 1;
        int cantidadObjetos = 100;
        int eleccion;
        boolean bool = true;
        int pasa = 1;
        int contadorBotones = 0;
        String respuestaCorrectaEstrella = "";
        String respuestaCorrectaNebulosa = "";
        String respuestaCorrectaPlaneta = "";
        String nombre1 = "";
        String nombre2 = "";
        String uRand, eviluRand;
        Estrellas estrellas[]=new Estrellas[cantidadObjetos];
        Planetas planetas[]=new Planetas[cantidadObjetos];
        Nebulosa nebulosas[]=new Nebulosa[cantidadObjetos];
        
        
        public void roundFOR(){
            for(int r=0;(r<(CuerposCelestes.tam[0]*4+CuerposCelestes.tam[1]*4+CuerposCelestes.tam[2]*2)/2)&&(CuerposCelestes.puntuacion[0]<220)&&(CuerposCelestes.puntuacion[1]<220);r++ ){
                            if(CuerposCelestes.puntuacion[0]>CuerposCelestes.puntuacion[1]){
                                CuerposCelestes.x=0;
                            }else if(CuerposCelestes.puntuacion[1]>CuerposCelestes.puntuacion[0]){
                                CuerposCelestes.x=1;
                            }else{
                                if(Math.random()>0.5){
                                    CuerposCelestes.x=1;
                                }else{
                                    CuerposCelestes.x=0;
                                }
                            }
            }
        }
        
        public void resetVAR(){
            for(int i=0;i<3;i++){
                            CuerposCelestes.cont[i]=0;
                        }
                        CuerposCelestes.puntuacion[0]=0;
                        CuerposCelestes.puntuacion[1]=0;
                        for(int i=0;i<CuerposCelestes.tam[0];i++){
                            estrellas[i].reseteo();
                        }
                        for(int i=0;i<CuerposCelestes.tam[1];i++){
                            planetas[i].reseteo();
                        }
                        for(int i=0;i<CuerposCelestes.tam[2];i++){
                            nebulosas[i].reseteo();
                        }
        }
        
        public void initComp(){
        String nombre1 = "";
        String nombre2 = "";
        int contadorPregunta = 1;
        int contadorTurno = 1;    

        //Declaración de estrellas
        estrellas[0] = new Estrellas("Arcturo","K", 36, "Bootes", 215);
        estrellas[1] = new Estrellas("Alpha Caeli","F", 66, "Caelum", 5);
        estrellas[2] = new Estrellas("Beta Camepardalis","G", 1000, "Camelopardalis", 1592);
        estrellas[3] = new Estrellas("Muhlifain","A", 4, "Centaurus", 95);
        estrellas[4] = new Estrellas("Cor Caroli","B", 110, "Canes Venatici", 83);
        estrellas[5] = new Estrellas("Omicron Ceti","M", 96, "Cetus", 8400);
        estrellas[6] = new Estrellas("Deneb Algiedi","A", 39, "Capricornius", 8);
        estrellas[7] = new Estrellas("Rigel Kentaurus","B", 4, "Centaurus", 85000);
        estrellas[8] = new Estrellas("Diphda","K", 96, "Cetus", 145);
        estrellas[9] = new Estrellas("Alpha Circini","A", 53, "Circinus", 11);
        //Declaración de planetas
        planetas[0] = new Planetas("Júpiter","gaseoso" ,588000000, 930, 10, "11 años y 314 dias");
        planetas[1] = new Planetas("Saturno","gaseoso" ,1300000000, -176, 11,"29 años y 167 dias");
        planetas[2] = new Planetas("Urano","gaseoso" ,2721, -218, 17, "84 años");
        planetas[3] = new Planetas("Venus","rocoso" ,40000000, 453, 5832, "225 dias");
        planetas[4] = new Planetas("Marte","rocoso" ,102000000, -129, 25, "2 años y 687 dias");
        //arreglar los int y long
        planetas[5] = new Planetas("Neptuno","gaseoso" ,450000000, -220, 16,"164 años");
        planetas[6] = new Planetas("Plutón","rocoso" ,600000000, -240, 153288, "247 años");
        //aqui para
        //Declaración de las nebulosas
        nebulosas[0] = new Nebulosa("Del Anillo", "Nebulosa de emision", "Lyra", 930,1779);
        nebulosas[1] = new Nebulosa("De la hormiga", "Nebulosa de emision", "Norma", -176,1922);
        nebulosas[2] = new Nebulosa("Esquimal", "Nebulosa de emision", "Geminis", -218,1787);
        nebulosas[3] = new Nebulosa("Del insecto", "Nebulosa de emision", "Scorpius", 453,1888);
        nebulosas[4] = new Nebulosa("Ojo de gato", "Nebulosa de emision", "Draco", -129,1786);
        nebulosas[5] = new Nebulosa("Reloj de arena", "Nebulosa de emision", "Musca", -220,1996);
        nebulosas[6] = new Nebulosa("Saturno", "Nebulosa de emision", "Acuario", -240,1782);
        }
    /**
     * Creates new form InterfazGrafica
     */
    
    public InterfazGrafica() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFrame2 = new javax.swing.JFrame();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        FrameEstrellas = new javax.swing.JFrame();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Respuesta2 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        labelPregunta2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        puntuacionJ2F3 = new javax.swing.JLabel();
        puntuacionJ1F3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton15 = new javax.swing.JButton();
        pregunta = new javax.swing.JLabel();
        nombreEstrella = new javax.swing.JLabel();
        FrameNebulosas = new javax.swing.JFrame();
        Respuesta3 = new javax.swing.JLabel();
        nombreEstrella1 = new javax.swing.JLabel();
        puntuacionJ2F4 = new javax.swing.JLabel();
        puntuacionJ1F4 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        labelPregunta3 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        pregunta1 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        FramePlanetas = new javax.swing.JFrame();
        Respuesta4 = new javax.swing.JLabel();
        nombreEstrella2 = new javax.swing.JLabel();
        puntuacionJ2F5 = new javax.swing.JLabel();
        puntuacionJ1F5 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        labelPregunta4 = new javax.swing.JLabel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        pregunta2 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Información = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        VerInforEstre = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        VerInfoNebu = new javax.swing.JButton();
        VerInfoPlane = new javax.swing.JButton();
        InformaciónEstrellas = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        EstrellasNombre = new javax.swing.JTextField();
        EstrellasTipo = new javax.swing.JTextField();
        EstrellasDistanciaT = new javax.swing.JTextField();
        EstrellasConstelación = new javax.swing.JTextField();
        EstrellasLuminosidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Avanzar = new javax.swing.JButton();
        RegresarPagina = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        AgregarEstrellas = new javax.swing.JButton();
        RegresarInfoEstreAInfoGen = new javax.swing.JButton();
        AgregaciónEstrellas = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        EstrellasNombre1 = new javax.swing.JTextField();
        EstrellasTipo1 = new javax.swing.JTextField();
        EstrellasDistanciaT1 = new javax.swing.JTextField();
        EstrellasConstelación1 = new javax.swing.JTextField();
        EstrellasLuminosidad1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        AgregarEstrellas1 = new javax.swing.JButton();
        RegresarInfoEstreAInfoGen1 = new javax.swing.JButton();
        InformaciónPlanetas = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        PlanetaNombre = new javax.swing.JTextField();
        PlanetaTipo = new javax.swing.JTextField();
        PlanetaDistancia = new javax.swing.JTextField();
        PlanetaTemp = new javax.swing.JTextField();
        PlanetaRotacion = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        Avanzar1 = new javax.swing.JButton();
        RegresarPagina1 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        PlanetaTraslacion = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        AgregarPlaneta = new javax.swing.JButton();
        RegresarInfoPlaneAInfoGen = new javax.swing.JButton();
        AgregaciónPlanetas = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        PlanetaNombre1 = new javax.swing.JTextField();
        PlanetaTipo1 = new javax.swing.JTextField();
        PlanetaDistancia1 = new javax.swing.JTextField();
        PlanetaTemp1 = new javax.swing.JTextField();
        PlanetaRotacion1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        PlanetaTraslacion1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        AgregarPlaneta1 = new javax.swing.JButton();
        RegresarInfoPlaneAInfoGen1 = new javax.swing.JButton();
        InformaciónNebulosas = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        NebulosaNombre = new javax.swing.JTextField();
        NebulosaTipo = new javax.swing.JTextField();
        NebulosaConstelacion = new javax.swing.JTextField();
        NebulosaTemp = new javax.swing.JTextField();
        NebulosaAñoDescubrimiento = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        Avanzar2 = new javax.swing.JButton();
        RegresarPagina2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        AgregarNebulosa = new javax.swing.JButton();
        RegresarInfoNebuAInfoGen = new javax.swing.JButton();
        AgregaciónNebulosas = new javax.swing.JFrame();
        jPanel12 = new javax.swing.JPanel();
        NebulosaNombre1 = new javax.swing.JTextField();
        NebulosaTipo1 = new javax.swing.JTextField();
        NebulosaConstelacion1 = new javax.swing.JTextField();
        NebulosaTemp1 = new javax.swing.JTextField();
        NebulosaAñoDescubrimiento1 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        AgregarNebulosa1 = new javax.swing.JButton();
        RegresarInfoNebuAInfoGen1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonPlay = new java.awt.Button();
        buttonExit = new java.awt.Button();
        buttonInfo = new java.awt.Button();

        jFrame1.setTitle("Nombres");
        jFrame1.setResizable(false);

        jLabel4.setText("Jugador 2");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Continuar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel2.setText("Escriban sus nombres");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("Jugador 1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jFrame2.setTitle("Seleccion de categoria");
        jFrame2.setResizable(false);

        jTextField3.setEditable(false);
        jTextField3.setForeground(new java.awt.Color(51, 51, 51));
        jTextField3.setToolTipText("");
        jTextField3.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel5.setText("Que categoria quieres?");

        jButton2.setText("Planetas");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Nebulosas");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Estrellas");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("RENDIRSE");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setText("Ronda 1");

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrame2Layout.createSequentialGroup()
                        .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrame2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jFrame2Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        FrameEstrellas.setTitle("Estrellas");
        FrameEstrellas.setResizable(false);

        jLabel8.setText("Turno de ");

        jTextField4.setEditable(false);
        jTextField4.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField4.setEnabled(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel9.setText(":");

        jTextField5.setEditable(false);
        jTextField5.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField5.setEnabled(false);

        jTextField6.setEditable(false);
        jTextField6.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField6.setEnabled(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        labelPregunta2.setText("0");

        jLabel26.setText("Pregunta ");

        jLabel16.setText(":");

        puntuacionJ2F3.setText("0");

        puntuacionJ1F3.setText("0");

        buttonGroup1.add(jRadioButton1);

        buttonGroup1.add(jRadioButton3);

        buttonGroup1.add(jRadioButton2);

        jButton15.setText("Aceptar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FrameEstrellasLayout = new javax.swing.GroupLayout(FrameEstrellas.getContentPane());
        FrameEstrellas.getContentPane().setLayout(FrameEstrellasLayout);
        FrameEstrellasLayout.setHorizontalGroup(
            FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameEstrellasLayout.createSequentialGroup()
                .addGroup(FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FrameEstrellasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FrameEstrellasLayout.createSequentialGroup()
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(FrameEstrellasLayout.createSequentialGroup()
                                .addGroup(FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FrameEstrellasLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9))
                                    .addGroup(FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(FrameEstrellasLayout.createSequentialGroup()
                                            .addComponent(jLabel26)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(labelPregunta2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(FrameEstrellasLayout.createSequentialGroup()
                                                    .addGap(21, 21, 21)
                                                    .addComponent(nombreEstrella, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(FrameEstrellasLayout.createSequentialGroup()
                                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(puntuacionJ1F3)
                                            .addGap(30, 30, 30)
                                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(puntuacionJ2F3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 5, Short.MAX_VALUE))))
                    .addGroup(FrameEstrellasLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(Respuesta2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        FrameEstrellasLayout.setVerticalGroup(
            FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameEstrellasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(nombreEstrella, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FrameEstrellasLayout.createSequentialGroup()
                        .addGroup(FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(labelPregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(11, 11, 11)))
                .addGap(45, 45, 45)
                .addGroup(FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Respuesta2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FrameEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntuacionJ2F3)
                    .addComponent(puntuacionJ1F3)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        FrameNebulosas.setTitle("Nebulosas");

        puntuacionJ2F4.setText("0");

        puntuacionJ1F4.setText("0");

        buttonGroup1.add(jRadioButton4);

        buttonGroup1.add(jRadioButton5);

        labelPregunta3.setText("0");

        buttonGroup1.add(jRadioButton6);

        jLabel29.setText("Pregunta ");

        jLabel19.setText(":");

        jButton16.setText("Aceptar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jTextField13.setEditable(false);
        jTextField13.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField13.setEnabled(false);

        jTextField14.setEditable(false);
        jTextField14.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField14.setEnabled(false);
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel10.setText("Turno de ");

        jTextField15.setEditable(false);
        jTextField15.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField15.setEnabled(false);

        jLabel11.setText(":");

        javax.swing.GroupLayout FrameNebulosasLayout = new javax.swing.GroupLayout(FrameNebulosas.getContentPane());
        FrameNebulosas.getContentPane().setLayout(FrameNebulosasLayout);
        FrameNebulosasLayout.setHorizontalGroup(
            FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameNebulosasLayout.createSequentialGroup()
                .addGroup(FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FrameNebulosasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FrameNebulosasLayout.createSequentialGroup()
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(FrameNebulosasLayout.createSequentialGroup()
                                .addGroup(FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FrameNebulosasLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addGroup(FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(FrameNebulosasLayout.createSequentialGroup()
                                            .addComponent(jLabel29)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(labelPregunta3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(pregunta1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(FrameNebulosasLayout.createSequentialGroup()
                                                    .addGap(21, 21, 21)
                                                    .addComponent(nombreEstrella1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(FrameNebulosasLayout.createSequentialGroup()
                                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(puntuacionJ1F4)
                                            .addGap(30, 30, 30)
                                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(puntuacionJ2F4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(FrameNebulosasLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(Respuesta3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        FrameNebulosasLayout.setVerticalGroup(
            FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameNebulosasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(nombreEstrella1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pregunta1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FrameNebulosasLayout.createSequentialGroup()
                        .addGroup(FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(labelPregunta3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(11, 11, 11)))
                .addGap(45, 45, 45)
                .addGroup(FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Respuesta3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FrameNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntuacionJ2F4)
                    .addComponent(puntuacionJ1F4)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        FramePlanetas.setTitle("Planetas");
        FramePlanetas.setResizable(false);

        puntuacionJ2F5.setText("0");

        puntuacionJ1F5.setText("0");

        buttonGroup1.add(jRadioButton7);

        buttonGroup1.add(jRadioButton8);

        labelPregunta4.setText("0");

        buttonGroup1.add(jRadioButton9);

        jLabel30.setText("Pregunta ");

        jLabel20.setText(":");

        jButton17.setText("Aceptar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jTextField16.setEditable(false);
        jTextField16.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField16.setEnabled(false);

        jTextField17.setEditable(false);
        jTextField17.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField17.setEnabled(false);
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jLabel12.setText("Turno de ");

        jTextField18.setEditable(false);
        jTextField18.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField18.setEnabled(false);

        jLabel13.setText(":");

        javax.swing.GroupLayout FramePlanetasLayout = new javax.swing.GroupLayout(FramePlanetas.getContentPane());
        FramePlanetas.getContentPane().setLayout(FramePlanetasLayout);
        FramePlanetasLayout.setHorizontalGroup(
            FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FramePlanetasLayout.createSequentialGroup()
                .addGroup(FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FramePlanetasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FramePlanetasLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(FramePlanetasLayout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelPregunta4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(FramePlanetasLayout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(nombreEstrella2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(FramePlanetasLayout.createSequentialGroup()
                                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(puntuacionJ1F5)
                                    .addGap(30, 30, 30)
                                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(puntuacionJ2F5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(FramePlanetasLayout.createSequentialGroup()
                                .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jRadioButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(FramePlanetasLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(Respuesta4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FramePlanetasLayout.setVerticalGroup(
            FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FramePlanetasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(nombreEstrella2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pregunta2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FramePlanetasLayout.createSequentialGroup()
                        .addGroup(FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(labelPregunta4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(11, 11, 11)))
                .addGap(45, 45, 45)
                .addGroup(FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Respuesta4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FramePlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntuacionJ2F5)
                    .addComponent(puntuacionJ1F5)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Información.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Información.setTitle("Información");

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        VerInforEstre.setText("Estrellas");
        VerInforEstre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInforEstreActionPerformed(evt);
            }
        });

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        VerInfoNebu.setText("Nebulosas");
        VerInfoNebu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInfoNebuActionPerformed(evt);
            }
        });

        VerInfoPlane.setText("Planetas");
        VerInfoPlane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInfoPlaneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(VerInfoNebu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VerInfoPlane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VerInforEstre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(Regresar)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(VerInforEstre)
                .addGap(18, 18, 18)
                .addComponent(VerInfoPlane)
                .addGap(18, 18, 18)
                .addComponent(VerInfoNebu)
                .addGap(47, 47, 47)
                .addComponent(Regresar)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout InformaciónLayout = new javax.swing.GroupLayout(Información.getContentPane());
        Información.getContentPane().setLayout(InformaciónLayout);
        InformaciónLayout.setHorizontalGroup(
            InformaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformaciónLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InformaciónLayout.setVerticalGroup(
            InformaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformaciónLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InformaciónEstrellas.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        InformaciónEstrellas.setTitle("Información de Estrellas");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        EstrellasNombre.setEditable(false);
        EstrellasNombre.setBackground(new java.awt.Color(255, 255, 255));
        EstrellasNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        EstrellasNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstrellasNombreActionPerformed(evt);
            }
        });

        EstrellasTipo.setEditable(false);
        EstrellasTipo.setBackground(new java.awt.Color(255, 255, 255));
        EstrellasTipo.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        EstrellasDistanciaT.setEditable(false);
        EstrellasDistanciaT.setBackground(new java.awt.Color(255, 255, 255));
        EstrellasDistanciaT.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        EstrellasDistanciaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstrellasDistanciaTActionPerformed(evt);
            }
        });

        EstrellasConstelación.setEditable(false);
        EstrellasConstelación.setBackground(new java.awt.Color(255, 255, 255));
        EstrellasConstelación.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        EstrellasLuminosidad.setEditable(false);
        EstrellasLuminosidad.setBackground(new java.awt.Color(255, 255, 255));
        EstrellasLuminosidad.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel7.setText("Nombre:");

        jLabel14.setText("Tipo:");

        jLabel15.setText("Distancia a la Tierra (Años luz):");

        jLabel17.setText("Constelación:");

        jLabel18.setText("Luminosidad");

        Avanzar.setText("Siguiente Estrella");
        Avanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvanzarActionPerformed(evt);
            }
        });

        RegresarPagina.setText("Estrella Previa");
        RegresarPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarPaginaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(RegresarPagina)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Avanzar))
                        .addComponent(EstrellasNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EstrellasTipo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EstrellasDistanciaT, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EstrellasConstelación, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EstrellasLuminosidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EstrellasNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EstrellasTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(3, 3, 3)
                .addComponent(EstrellasDistanciaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(3, 3, 3)
                .addComponent(EstrellasConstelación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EstrellasLuminosidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Avanzar)
                    .addComponent(RegresarPagina))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));

        AgregarEstrellas.setText("Agregar Estrella");
        AgregarEstrellas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarEstrellasActionPerformed(evt);
            }
        });

        RegresarInfoEstreAInfoGen.setText("Regresar");
        RegresarInfoEstreAInfoGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarInfoEstreAInfoGenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AgregarEstrellas)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(RegresarInfoEstreAInfoGen, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(AgregarEstrellas)
                .addGap(32, 32, 32)
                .addComponent(RegresarInfoEstreAInfoGen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout InformaciónEstrellasLayout = new javax.swing.GroupLayout(InformaciónEstrellas.getContentPane());
        InformaciónEstrellas.getContentPane().setLayout(InformaciónEstrellasLayout);
        InformaciónEstrellasLayout.setHorizontalGroup(
            InformaciónEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformaciónEstrellasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        InformaciónEstrellasLayout.setVerticalGroup(
            InformaciónEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InformaciónEstrellasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InformaciónEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgregaciónEstrellas.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        AgregaciónEstrellas.setTitle("Agregar Estrella");

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        EstrellasNombre1.setBackground(new java.awt.Color(255, 255, 255));
        EstrellasNombre1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        EstrellasNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstrellasNombre1ActionPerformed(evt);
            }
        });

        EstrellasTipo1.setBackground(new java.awt.Color(255, 255, 255));
        EstrellasTipo1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        EstrellasDistanciaT1.setBackground(new java.awt.Color(255, 255, 255));
        EstrellasDistanciaT1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        EstrellasDistanciaT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstrellasDistanciaT1ActionPerformed(evt);
            }
        });

        EstrellasConstelación1.setBackground(new java.awt.Color(255, 255, 255));
        EstrellasConstelación1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        EstrellasLuminosidad1.setBackground(new java.awt.Color(255, 255, 255));
        EstrellasLuminosidad1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel21.setText("Nombre:");

        jLabel22.setText("Tipo:");

        jLabel23.setText("Distancia a la Tierra (Años luz):");

        jLabel24.setText("Constelación:");

        jLabel25.setText("Luminosidad (soles):");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(EstrellasNombre1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EstrellasTipo1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EstrellasDistanciaT1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EstrellasConstelación1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EstrellasLuminosidad1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EstrellasNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EstrellasTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(3, 3, 3)
                .addComponent(EstrellasDistanciaT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addGap(3, 3, 3)
                .addComponent(EstrellasConstelación1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EstrellasLuminosidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));

        AgregarEstrellas1.setText("Agregar ");
        AgregarEstrellas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarEstrellas1ActionPerformed(evt);
            }
        });

        RegresarInfoEstreAInfoGen1.setText("Regresar");
        RegresarInfoEstreAInfoGen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarInfoEstreAInfoGen1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RegresarInfoEstreAInfoGen1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarEstrellas1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(AgregarEstrellas1)
                .addGap(42, 42, 42)
                .addComponent(RegresarInfoEstreAInfoGen1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AgregaciónEstrellasLayout = new javax.swing.GroupLayout(AgregaciónEstrellas.getContentPane());
        AgregaciónEstrellas.getContentPane().setLayout(AgregaciónEstrellasLayout);
        AgregaciónEstrellasLayout.setHorizontalGroup(
            AgregaciónEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregaciónEstrellasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgregaciónEstrellasLayout.setVerticalGroup(
            AgregaciónEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgregaciónEstrellasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AgregaciónEstrellasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        InformaciónPlanetas.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        InformaciónPlanetas.setTitle("Información de Planetas");

        jPanel6.setBackground(new java.awt.Color(255, 153, 255));

        PlanetaNombre.setEditable(false);
        PlanetaNombre.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PlanetaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlanetaNombreActionPerformed(evt);
            }
        });

        PlanetaTipo.setEditable(false);
        PlanetaTipo.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaTipo.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        PlanetaDistancia.setEditable(false);
        PlanetaDistancia.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaDistancia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PlanetaDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlanetaDistanciaActionPerformed(evt);
            }
        });

        PlanetaTemp.setEditable(false);
        PlanetaTemp.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaTemp.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        PlanetaRotacion.setEditable(false);
        PlanetaRotacion.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaRotacion.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel27.setText("Nombre:");

        jLabel28.setText("Tipo:");

        jLabel31.setText("Distancia a la Tierra (km):");

        jLabel32.setText("Temperatura Minima:");

        jLabel33.setText("Rotación (Días):");

        Avanzar1.setText("Siguiente Planeta");
        Avanzar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Avanzar1ActionPerformed(evt);
            }
        });

        RegresarPagina1.setText("Planeta Previo");
        RegresarPagina1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarPagina1ActionPerformed(evt);
            }
        });

        jLabel34.setText("Traslación (Años y días):");

        PlanetaTraslacion.setEditable(false);
        PlanetaTraslacion.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaTraslacion.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(RegresarPagina1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Avanzar1))
                        .addComponent(PlanetaNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PlanetaTipo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PlanetaDistancia, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PlanetaTemp, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PlanetaRotacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PlanetaTraslacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlanetaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlanetaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addGap(3, 3, 3)
                .addComponent(PlanetaDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32)
                .addGap(3, 3, 3)
                .addComponent(PlanetaTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlanetaRotacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlanetaTraslacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Avanzar1)
                    .addComponent(RegresarPagina1))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(153, 255, 153));

        AgregarPlaneta.setText("Agregar Planeta");
        AgregarPlaneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPlanetaActionPerformed(evt);
            }
        });

        RegresarInfoPlaneAInfoGen.setText("Regresar");
        RegresarInfoPlaneAInfoGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarInfoPlaneAInfoGenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AgregarPlaneta)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(RegresarInfoPlaneAInfoGen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(AgregarPlaneta)
                .addGap(31, 31, 31)
                .addComponent(RegresarInfoPlaneAInfoGen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout InformaciónPlanetasLayout = new javax.swing.GroupLayout(InformaciónPlanetas.getContentPane());
        InformaciónPlanetas.getContentPane().setLayout(InformaciónPlanetasLayout);
        InformaciónPlanetasLayout.setHorizontalGroup(
            InformaciónPlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformaciónPlanetasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InformaciónPlanetasLayout.setVerticalGroup(
            InformaciónPlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InformaciónPlanetasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InformaciónPlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgregaciónPlanetas.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        AgregaciónPlanetas.setTitle("Agregar Planeta");

        jPanel8.setBackground(new java.awt.Color(255, 153, 255));

        PlanetaNombre1.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaNombre1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PlanetaNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlanetaNombre1ActionPerformed(evt);
            }
        });

        PlanetaTipo1.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaTipo1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        PlanetaDistancia1.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaDistancia1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PlanetaDistancia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlanetaDistancia1ActionPerformed(evt);
            }
        });

        PlanetaTemp1.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaTemp1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        PlanetaRotacion1.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaRotacion1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel35.setText("Nombre:");

        jLabel36.setText("Tipo:");

        jLabel37.setText("Distancia a la Tierra (km):");

        jLabel38.setText("Temperatura Minima:");

        jLabel39.setText("Rotación (Días):");

        jLabel40.setText("Traslación (Años y días):");

        PlanetaTraslacion1.setBackground(new java.awt.Color(255, 255, 255));
        PlanetaTraslacion1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(PlanetaNombre1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PlanetaTipo1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PlanetaDistancia1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PlanetaTemp1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PlanetaRotacion1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PlanetaTraslacion1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlanetaNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlanetaTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37)
                .addGap(3, 3, 3)
                .addComponent(PlanetaDistancia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addGap(3, 3, 3)
                .addComponent(PlanetaTemp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlanetaRotacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlanetaTraslacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(153, 255, 153));

        AgregarPlaneta1.setText("Agregar");
        AgregarPlaneta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPlaneta1ActionPerformed(evt);
            }
        });

        RegresarInfoPlaneAInfoGen1.setText("Regresar");
        RegresarInfoPlaneAInfoGen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarInfoPlaneAInfoGen1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(RegresarInfoPlaneAInfoGen1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(AgregarPlaneta1)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(AgregarPlaneta1)
                .addGap(32, 32, 32)
                .addComponent(RegresarInfoPlaneAInfoGen1)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AgregaciónPlanetasLayout = new javax.swing.GroupLayout(AgregaciónPlanetas.getContentPane());
        AgregaciónPlanetas.getContentPane().setLayout(AgregaciónPlanetasLayout);
        AgregaciónPlanetasLayout.setHorizontalGroup(
            AgregaciónPlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregaciónPlanetasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AgregaciónPlanetasLayout.setVerticalGroup(
            AgregaciónPlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgregaciónPlanetasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AgregaciónPlanetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        InformaciónNebulosas.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        InformaciónNebulosas.setTitle("Información de Nebulosas");

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));

        NebulosaNombre.setEditable(false);
        NebulosaNombre.setBackground(new java.awt.Color(255, 255, 255));
        NebulosaNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        NebulosaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NebulosaNombreActionPerformed(evt);
            }
        });

        NebulosaTipo.setEditable(false);
        NebulosaTipo.setBackground(new java.awt.Color(255, 255, 255));
        NebulosaTipo.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        NebulosaConstelacion.setEditable(false);
        NebulosaConstelacion.setBackground(new java.awt.Color(255, 255, 255));
        NebulosaConstelacion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        NebulosaConstelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NebulosaConstelacionActionPerformed(evt);
            }
        });

        NebulosaTemp.setEditable(false);
        NebulosaTemp.setBackground(new java.awt.Color(255, 255, 255));
        NebulosaTemp.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        NebulosaAñoDescubrimiento.setEditable(false);
        NebulosaAñoDescubrimiento.setBackground(new java.awt.Color(255, 255, 255));
        NebulosaAñoDescubrimiento.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel41.setText("Nombre:");

        jLabel42.setText("Tipo:");

        jLabel43.setText("Constelación:");

        jLabel44.setText("Temperatura Minima:");

        jLabel45.setText("Año de Descubrimiento:");

        Avanzar2.setText("Siguiente Nebulosa");
        Avanzar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Avanzar2ActionPerformed(evt);
            }
        });

        RegresarPagina2.setText("Nebulosa Previa");
        RegresarPagina2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarPagina2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(RegresarPagina2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Avanzar2))
                        .addComponent(NebulosaNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NebulosaTipo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NebulosaConstelacion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NebulosaTemp, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NebulosaAñoDescubrimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NebulosaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NebulosaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addGap(3, 3, 3)
                .addComponent(NebulosaConstelacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel44)
                .addGap(3, 3, 3)
                .addComponent(NebulosaTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NebulosaAñoDescubrimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegresarPagina2)
                    .addComponent(Avanzar2))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 153, 153));

        AgregarNebulosa.setText("Agregar Nebulosa");
        AgregarNebulosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarNebulosaActionPerformed(evt);
            }
        });

        RegresarInfoNebuAInfoGen.setText("Regresar");
        RegresarInfoNebuAInfoGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarInfoNebuAInfoGenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(AgregarNebulosa))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(RegresarInfoNebuAInfoGen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(AgregarNebulosa)
                .addGap(44, 44, 44)
                .addComponent(RegresarInfoNebuAInfoGen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout InformaciónNebulosasLayout = new javax.swing.GroupLayout(InformaciónNebulosas.getContentPane());
        InformaciónNebulosas.getContentPane().setLayout(InformaciónNebulosasLayout);
        InformaciónNebulosasLayout.setHorizontalGroup(
            InformaciónNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformaciónNebulosasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InformaciónNebulosasLayout.setVerticalGroup(
            InformaciónNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformaciónNebulosasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InformaciónNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        AgregaciónNebulosas.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        AgregaciónNebulosas.setTitle("Información de Nebulosas");

        jPanel12.setBackground(new java.awt.Color(153, 153, 255));

        NebulosaNombre1.setBackground(new java.awt.Color(255, 255, 255));
        NebulosaNombre1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        NebulosaNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NebulosaNombre1ActionPerformed(evt);
            }
        });

        NebulosaTipo1.setBackground(new java.awt.Color(255, 255, 255));
        NebulosaTipo1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        NebulosaConstelacion1.setBackground(new java.awt.Color(255, 255, 255));
        NebulosaConstelacion1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        NebulosaConstelacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NebulosaConstelacion1ActionPerformed(evt);
            }
        });

        NebulosaTemp1.setBackground(new java.awt.Color(255, 255, 255));
        NebulosaTemp1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        NebulosaAñoDescubrimiento1.setBackground(new java.awt.Color(255, 255, 255));
        NebulosaAñoDescubrimiento1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel46.setText("Nombre:");

        jLabel47.setText("Tipo:");

        jLabel48.setText("Constelación:");

        jLabel49.setText("Temperatura Minima:");

        jLabel50.setText("Año de Descubrimiento:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(NebulosaNombre1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NebulosaTipo1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NebulosaConstelacion1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NebulosaTemp1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NebulosaAñoDescubrimiento1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NebulosaNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NebulosaTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel48)
                .addGap(3, 3, 3)
                .addComponent(NebulosaConstelacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel49)
                .addGap(3, 3, 3)
                .addComponent(NebulosaTemp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NebulosaAñoDescubrimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 153, 153));

        AgregarNebulosa1.setText("Agregar");
        AgregarNebulosa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarNebulosa1ActionPerformed(evt);
            }
        });

        RegresarInfoNebuAInfoGen1.setText("Regresar");
        RegresarInfoNebuAInfoGen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarInfoNebuAInfoGen1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(RegresarInfoNebuAInfoGen1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AgregarNebulosa1)
                .addGap(42, 42, 42))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(AgregarNebulosa1)
                .addGap(42, 42, 42)
                .addComponent(RegresarInfoNebuAInfoGen1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AgregaciónNebulosasLayout = new javax.swing.GroupLayout(AgregaciónNebulosas.getContentPane());
        AgregaciónNebulosas.getContentPane().setLayout(AgregaciónNebulosasLayout);
        AgregaciónNebulosasLayout.setHorizontalGroup(
            AgregaciónNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregaciónNebulosasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        AgregaciónNebulosasLayout.setVerticalGroup(
            AgregaciónNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgregaciónNebulosasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AgregaciónNebulosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conozca el Universo");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Serif", 0, 36)); // NOI18N
        jLabel1.setText("Conozca el Universo");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonPlay.setBackground(new java.awt.Color(255, 255, 255));
        buttonPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonPlay.setLabel("Jugar");
        buttonPlay.setName("1"); // NOI18N
        buttonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlayActionPerformed(evt);
            }
        });

        buttonExit.setBackground(new java.awt.Color(255, 255, 255));
        buttonExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonExit.setLabel("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonInfo.setBackground(new java.awt.Color(255, 255, 255));
        buttonInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonInfo.setLabel("Info");
        buttonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(buttonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlayActionPerformed
        initComp();
        this.setVisible(false);
        this.setVisible(false);
        jFrame1.setVisible(true);
        jFrame1.setSize(420, 323);
    }//GEN-LAST:event_buttonPlayActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        JOptionPane.showMessageDialog(null, "Gracias por jugar!");
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInfoActionPerformed
        this.setVisible(false);
        Información.setVisible(true);
        Información.setSize(290,345);
        
    }//GEN-LAST:event_buttonInfoActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetVAR();

        nombre1 = jTextField2.getText();
        nombre2 = jTextField1.getText();

        if (nombre1.equals("") || nombre2.equals("")){
            JOptionPane.showMessageDialog(null,"Debes poner un nombre para cada jugador");
        }else{
            jFrame1.setVisible(false);
            jFrame2.setVisible(true);
            jFrame2.setSize(400, 300);

            if(Math.random()>0.5){
                jTextField3.setText(nombre1);
                uRand = nombre1;
                turno = 1;
                eviluRand = nombre2;
                pasa = 1;
            }else{
                jTextField3.setText(nombre2);
                uRand = nombre2;
                turno = 2;
                eviluRand = nombre1;
                pasa = 2;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         JOptionPane.showMessageDialog(null, "El jugador " + jTextField3.getText() + " se ha rendido.");
        if (jTextField3.getText().equals(nombre1)){
            JOptionPane.showMessageDialog(null, nombre2 + " ha ganado!");
        }else{
            JOptionPane.showMessageDialog(null, nombre1 + " ha ganado!");
        }
        
        String nombre1 = "";
        String nombre2 = "";
        int contadorPregunta = 1;
        int contadorTurno = 1; 
        contadorPregunta = 1;
        contadorTurno = 1;
        int cantidadObjetos = 100;
        int eleccion;
        boolean[] preguntasUsadas = new boolean[4];    
        puntuacionJ1 = 0;
        puntuacionJ2 = 0;
        String nombre;
        String tipo;
        String constelacion;
        int tempMin;
        long distanciaTierra;
        boolean usado;
        int contador=0;

    //Contador para la cantidad de preguntas que han pasado

        String respuestaCorrectaEstrella = "";
        String respuestaCorrectaNebulosa = "";
        String respuestaCorrectaPlaneta = "";
        nombre1 = "";
        nombre2 = "";
        String uRand, eviluRand;
        jFrame2.setVisible(false);
        InterfazGrafica frame = new InterfazGrafica();
        frame.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             contadorBotones = contadorBotones + 1;
            contadorPregunta = contadorPregunta + 1;
            respondioMal2 = false;
            respondioMal1 = false;
            respondieronMal = 0;
            
            jFrame2.setVisible(false);
            labelPregunta4.setText(""+contadorPregunta);
            if (bool){
               jTextField18.setText(uRand); 
               bool = false;
            }
            
            jTextField18.setText(jTextField3.getText());
            jTextField16.setText(nombre1);
            puntuacionJ1F5.setText(""+puntuacionJ1);
            jTextField17.setText(nombre2);
            puntuacionJ2F5.setText(""+puntuacionJ2);
            FramePlanetas.setVisible(true);
            FramePlanetas.setSize(520, 340);
            
            int a= (int) (Math.random()*6);
            int b= (int) (Math.random()*2);
            
            int one = (int) (Math.random()*3);
            int two;
            int three;
            
            int r1;
            int r2;
            
            do{
                r1=(int) (Math.random()*6);
            }while(r1==a);
                
            do{
                r2=(int) (Math.random()*3);
            }while(r2==a||r2==r1);
            
            
            String respuestaIncorrecta1P = "";
            String respuestaIncorrecta2P = "";
            
            switch (b){
            case 0:
                respuestaCorrectaPlaneta = "" +planetas[a].getDistanciaTierra();
                respuestaIncorrecta1P = "" + planetas[r1].getDistanciaTierra();
                respuestaIncorrecta2P = "" + planetas[r2].getDistanciaTierra();
                break;
            case 1:
                respuestaCorrectaPlaneta = planetas[a].getTraslacion();
                respuestaIncorrecta1P = planetas[r1].getTraslacion();
                respuestaIncorrecta2P = planetas[r2].getTraslacion();
                break;
            case 2:
                respuestaCorrectaPlaneta = planetas[a].getTipo();
                respuestaIncorrecta1P = planetas[r1].getTipo();
                respuestaIncorrecta2P = planetas[r2].getTipo();
                break;
            case 3:
                respuestaCorrectaPlaneta = "" + planetas[a].getTempMin();
                respuestaIncorrecta1P = "" + planetas[r1].getTempMin();
                respuestaIncorrecta2P = "" + planetas[r2].getTempMin();
                break;
            }
            int res;
            
            nombreEstrella2.setText(planetas[a].getNombre());
        
            String respuestas[]= new String [3];
            respuestas[one]=respuestaCorrectaPlaneta;
            do{
                two=(int) (Math.random()*3);
            }while(two==one);
            respuestas[two]=respuestaIncorrecta1P;
            do{
                three=(int) (Math.random()*3);
            }while(three==one||three==two);
            respuestas[three]=respuestaIncorrecta2P;
            
            jRadioButton7.setText(respuestas[0]);
            jRadioButton8.setText(respuestas[1]);
            jRadioButton9.setText(respuestas[2]);
            
            pregunta2.setText(planetas[a].pregunta[b]);
            
            
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
           seleccionTurnoImpar = 0;
            String NombreEnJuego = "";
            
            NombreEnJuego = jTextField3.getText();
            if (NombreEnJuego.equals(nombre1)){
                jTextField4.setText(nombre1);
            }
            if (NombreEnJuego.equals(nombre2)){
                jTextField4.setText(nombre2);
            }
            
            contadorBotones = contadorBotones + 1;
            contadorPregunta = contadorPregunta + 1;
            respondioMal2 = false;
            respondioMal1 = false;
            respondieronMal = 0;
            
            jFrame2.setVisible(false);
            labelPregunta2.setText(""+contadorPregunta);
            
            jTextField5.setText(nombre1);
            puntuacionJ1F3.setText(""+puntuacionJ1);
            jTextField6.setText(nombre2);
            puntuacionJ2F3.setText(""+puntuacionJ2);
            FrameEstrellas.setVisible(true);
            FrameEstrellas.setSize(420, 340);
            
            int a= (int) (Math.random()*9);
            int b= (int) (Math.random()*4);
            
            int one = (int) (Math.random()*3);
            int two;
            int three;
            
            int r1;
            int r2;
            
            do{
                r1=(int) (Math.random()*9);
            }while(r1==a);
                
            do{
                r2=(int) (Math.random()*9);
            }while(r2==a||r2==r1);
            
            
            String respuestaIncorrecta1 = "";
            String respuestaIncorrecta2 = "";
            
            switch (b){
            case 0:
                respuestaCorrectaEstrella = estrellas[a].getConstelacion();
                respuestaIncorrecta1 = estrellas[r1].getConstelacion();
                respuestaIncorrecta2 = estrellas[r2].getConstelacion();
                break;
            case 1:
                respuestaCorrectaEstrella = ""+estrellas[a].getDistanciaTierra();
                respuestaIncorrecta1 =""+ estrellas[r1].getDistanciaTierra();
                respuestaIncorrecta2 =""+ estrellas[r2].getDistanciaTierra();
                break;
            case 2:
                respuestaCorrectaEstrella = ""+estrellas[a].getTipo();
                respuestaIncorrecta1 = estrellas[r1].getTipo();
                respuestaIncorrecta2 = estrellas[r2].getTipo();
                break;
            case 3:
                respuestaCorrectaEstrella = ""+estrellas[a].getluminosidad();
                respuestaIncorrecta1 =""+ estrellas[r1].getluminosidad();
                respuestaIncorrecta2 =""+ estrellas[r2].getluminosidad();
                break;
            }
            int res;
            
            nombreEstrella.setText(estrellas[a].getNombre());
        
        String respuestas[]= new String [3];
        respuestas[one]=respuestaCorrectaEstrella;
        do{
            two=(int) (Math.random()*3);
        }while(two==one);
        respuestas[two]=respuestaIncorrecta1;
        do{
            three=(int) (Math.random()*3);
        }while(three==one||three==two);
        respuestas[three]=respuestaIncorrecta2;
            
            jRadioButton1.setText(respuestas[0]);
            jRadioButton2.setText(respuestas[1]);
            jRadioButton3.setText(respuestas[2]);
            
            pregunta.setText(estrellas[a].pregunta[b]);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            contadorBotones = contadorBotones + 1;
            contadorPregunta = contadorPregunta + 1;
            respondioMal2 = false;
            respondioMal1 = false;
            respondieronMal = 0;
            noCambio = false;
            
            
            jFrame2.setVisible(false);
            labelPregunta3.setText(""+contadorPregunta);
            if (bool){
               jTextField15.setText(uRand); 
               bool = false;
            }
            
            jTextField15.setText(jTextField3.getText());
            jTextField13.setText(nombre1);
            puntuacionJ1F4.setText(""+puntuacionJ1);
            jTextField14.setText(nombre2);
            puntuacionJ2F4.setText(""+puntuacionJ2);
            FrameNebulosas.setVisible(true);
            FrameNebulosas.setSize(420, 340);
            
            int a= (int) (Math.random()*6);
            int b= (int) (Math.random()*2);
            
            int one = (int) (Math.random()*3);
            int two;
            int three;
            
            int r1;
            int r2;
            
            do{
                r1=(int) (Math.random()*6);
            }while(r1==a);
                
            do{
                r2=(int) (Math.random()*3);
            }while(r2==a||r2==r1);
            
            
            String respuestaIncorrecta1N = "";
            String respuestaIncorrecta2N = "";
            
            switch (b){
            case 0:
                respuestaCorrectaNebulosa ="" +nebulosas[a].getAñoDescubrimiento();
                respuestaIncorrecta1N ="" +nebulosas[r1].getAñoDescubrimiento();
                respuestaIncorrecta2N ="" + nebulosas[r2].getAñoDescubrimiento();
                break;
            case 1:
                respuestaCorrectaNebulosa = ""+nebulosas[a].getConstelacion();
                respuestaIncorrecta1N =""+ nebulosas[r1].getConstelacion();
                respuestaIncorrecta2N =""+ nebulosas[r2].getConstelacion();
                break;
            }
            int res;
            
            nombreEstrella1.setText(nebulosas[a].getNombre());
        
        String respuestas[]= new String [3];
        respuestas[one]=respuestaCorrectaNebulosa;
        do{
            two=(int) (Math.random()*3);
        }while(two==one);
        respuestas[two]=respuestaIncorrecta1N;
        do{
            three=(int) (Math.random()*3);
        }while(three==one||three==two);
        respuestas[three]=respuestaIncorrecta2N;
            
            jRadioButton4.setText(respuestas[0]);
            jRadioButton5.setText(respuestas[1]);
            jRadioButton6.setText(respuestas[2]);
            
            pregunta1.setText(nebulosas[a].pregunta[b]);
            
            jFrame2.setVisible(false);
            labelPregunta2.setText(""+contadorPregunta);         
                   
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        
    }//GEN-LAST:event_jTextField6ActionPerformed
    
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String NombreEnJuego = jTextField4.getText();
        
        if (NombreEnJuego.equals(nombre1)){ //jugador 1
                if(jRadioButton1.isSelected()){
                    String respuestaU = jRadioButton1.getText();

                    if (respuestaU.equals(respuestaCorrectaEstrella)){
                        JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                        puntuacionJ1 = puntuacionJ1 + 10;
                        puntuacionJ1F3.setText(""+puntuacionJ1);

                        jTextField3.setText(nombre2);
                        jTextField4.setText(nombre2);
                        FrameEstrellas.setVisible(false);
                        jFrame2.setVisible(true);
                        jFrame2.setSize(420, 323);
                        seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                    }else{
                    JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                    puntuacionJ1 = puntuacionJ1 - 4;
                    puntuacionJ1F3.setText(""+puntuacionJ1);

                    jTextField3.setText(nombre2);
                    respondioMal1 = true;
                    jTextField4.setText(nombre2);
                }
                }

                if(jRadioButton2.isSelected()){
                    String respuestaU = jRadioButton2.getText();

                    if (respuestaU.equals(respuestaCorrectaEstrella)){
                        JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                        puntuacionJ1 = puntuacionJ1 + 10;
                        puntuacionJ1F3.setText(""+puntuacionJ1);

                        jTextField3.setText(nombre2);
                        jTextField4.setText(nombre2);
                        FrameEstrellas.setVisible(false);
                        jFrame2.setVisible(true);
                        jFrame2.setSize(420, 323);
                        seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                    }else{
                    JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                    puntuacionJ1 = puntuacionJ1 - 4;
                    puntuacionJ1F3.setText(""+puntuacionJ1);

                    jTextField3.setText(nombre2);
                    respondioMal1 = true;
                    jTextField4.setText(nombre2);
                }
                } 

                if(jRadioButton3.isSelected()){
                    String respuestaU = jRadioButton3.getText();

                    if (respuestaU.equals(respuestaCorrectaEstrella)){
                        JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                        puntuacionJ1 = puntuacionJ1 + 10;
                        puntuacionJ1F3.setText(""+puntuacionJ1);

                        jTextField3.setText(nombre2);
                        jTextField4.setText(nombre2);
                        FrameEstrellas.setVisible(false);
                        jFrame2.setVisible(true);
                        jFrame2.setSize(420, 323);
                        seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                    }else{
                    JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                    puntuacionJ1 = puntuacionJ1 -4;
                    respondioMal1 = true;
                    puntuacionJ1F3.setText(""+puntuacionJ1);

                    jTextField3.setText(nombre2);
                    jTextField4.setText(nombre2);
                }
                } 
            }
            if (NombreEnJuego.equals(nombre2)){// jugador 2
                            
                        if(jRadioButton1.isSelected()){
                        String respuestaU = jRadioButton1.getText();

                        if (respuestaU.equals(respuestaCorrectaEstrella)){
                            JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                            puntuacionJ2 = puntuacionJ2 + 10;
                            puntuacionJ2F3.setText(""+puntuacionJ2);
                            turno = 1;
                            jTextField3.setText(nombre1);
                            jTextField4.setText(nombre1);
                            FrameEstrellas.setVisible(false);
                            jFrame2.setVisible(true);
                            jFrame2.setSize(420, 323);
                            seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                        }else{
                        JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                        puntuacionJ2 = puntuacionJ2 - 4;
                        respondioMal2 = true;
                        puntuacionJ2F3.setText(""+puntuacionJ2);
                        turno = 1;
                        jTextField4.setText(nombre1);
                    }
                    }

                    if(jRadioButton2.isSelected()){
                        String respuestaU = jRadioButton2.getText();

                        if (respuestaU.equals(respuestaCorrectaEstrella)){
                            JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                            puntuacionJ2 = puntuacionJ2 + 10;
                            puntuacionJ2F3.setText(""+puntuacionJ2);
                            turno = 1;
                            jTextField3.setText(nombre1);
                            jTextField4.setText(nombre1);
                            FrameEstrellas.setVisible(false);
                            jFrame2.setVisible(true);
                            jFrame2.setSize(420, 323);
                            seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                        }else{
                            JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                            puntuacionJ2 = puntuacionJ2 - 4;
                            puntuacionJ2F3.setText(""+puntuacionJ2);
                            respondioMal2 = true;
                            turno = 1;
                            jTextField3.setText(nombre1);
                            jTextField4.setText(nombre1);
                    }
                    } 

                    if(jRadioButton3.isSelected()){
                        String respuestaU = jRadioButton3.getText();

                        if (respuestaU.equals(respuestaCorrectaEstrella)){
                            JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                            puntuacionJ2 = puntuacionJ2 + 10;
                            puntuacionJ2F3.setText(""+puntuacionJ2);
                            turno = 1;
                            jTextField3.setText(nombre1);
                            jTextField4.setText(nombre1);
                            FrameEstrellas.setVisible(false);
                            jFrame2.setVisible(true);
                            jFrame2.setSize(420, 323);
                            seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                        }else{
                        JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                        puntuacionJ2 = puntuacionJ2 - 4;
                        puntuacionJ2F3.setText(""+puntuacionJ2);
                        respondioMal2 = true;
                        turno = 1;
                        jTextField3.setText(nombre1);
                        jTextField4.setText(nombre1);

                    }
                    }
            }
            
        if (contadorBotones == 2){ // subir la ronda cada 2 turnos
            contadorTurno = contadorTurno + 1;
            jLabel6.setText("Ronda "+contadorTurno);
            contadorBotones = 0;
        }
        if (respondioMal1 && respondioMal2){ // respondieron mal los 2
            JOptionPane.showMessageDialog(null, "Los dos respondieron mal la pregunta.");
            JOptionPane.showMessageDialog(null, "La respuesta correcta era " + respuestaCorrectaEstrella +"!");
                FrameEstrellas.setVisible(false);
                
                if (NombreEnJuego.equals(nombre1)){
                    jTextField3.setText(nombre2);
                    jTextField4.setText(nombre2);
                }
                if (NombreEnJuego.equals(nombre2)){
                    jTextField3.setText(nombre1);
                    jTextField4.setText(nombre1);
                }
                seleccionTurnoImpar = seleccionTurnoImpar + 1;
                jFrame2.setVisible(true);
                jFrame2.setSize(420, 323);
                if (pasa == 1){
                    jTextField3.setText(nombre2);
                    jTextField4.setText(nombre2);
                    pasa = 2;
                } else{
                    jTextField3.setText(nombre1);
                    jTextField4.setText(nombre1);
                    pasa = 1;
                }
        }
            
        
        
        if (puntuacionJ1 >= 40){
            JOptionPane.showMessageDialog(null, "El jugador 1 ha ganado!");
            FrameEstrellas.setVisible(false);
            jFrame2.setVisible(false);
            InterfazGrafica frame = new InterfazGrafica();
            frame.setVisible(true);
        }
        if (puntuacionJ2 >= 40){
            JOptionPane.showMessageDialog(null, "El jugador 2 ha ganado!");
            FrameEstrellas.setVisible(false);
            jFrame2.setVisible(false);
            InterfazGrafica frame = new InterfazGrafica();
            frame.setVisible(true);
        }
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
         String NombreEnJuego = jTextField15.getText();
        
        if (NombreEnJuego.equals(nombre1)){ //jugador 1
                if(jRadioButton4.isSelected()){
                    String respuestaU = jRadioButton4.getText();

                    if (respuestaU.equals(respuestaCorrectaNebulosa)){
                        JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                        puntuacionJ1 = puntuacionJ1 + 10;
                        puntuacionJ1F4.setText(""+puntuacionJ1);

                        jTextField3.setText(nombre2);
                        jTextField15.setText(nombre2);
                        FrameNebulosas.setVisible(false);
                        jFrame2.setVisible(true);
                        jFrame2.setSize(420, 323);
                        seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                    }else{
                    JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                    puntuacionJ1 = puntuacionJ1 - 4;
                    puntuacionJ1F4.setText(""+puntuacionJ1);

                    jTextField3.setText(nombre2);
                    respondioMal1 = true;
                    jTextField15.setText(nombre2);
                }
                }

                if(jRadioButton5.isSelected()){
                    String respuestaU = jRadioButton5.getText();

                    if (respuestaU.equals(respuestaCorrectaNebulosa)){
                        JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                        puntuacionJ1 = puntuacionJ1 + 10;
                        puntuacionJ1F4.setText(""+puntuacionJ1);

                        jTextField3.setText(nombre2);
                        jTextField15.setText(nombre2);
                        FrameNebulosas.setVisible(false);
                        jFrame2.setVisible(true);
                        jFrame2.setSize(420, 323);
                        seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                    }else{
                    JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                    puntuacionJ1 = puntuacionJ1 - 4;
                    puntuacionJ1F4.setText(""+puntuacionJ1);

                    jTextField3.setText(nombre2);
                    respondioMal1 = true;
                    jTextField15.setText(nombre2);
                }
                } 

                if(jRadioButton6.isSelected()){
                    String respuestaU = jRadioButton6.getText();

                    if (respuestaU.equals(respuestaCorrectaNebulosa)){
                        JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                        puntuacionJ1 = puntuacionJ1 + 10;
                        puntuacionJ1F4.setText(""+puntuacionJ1);

                        jTextField3.setText(nombre2);
                        jTextField15.setText(nombre2);
                        FrameNebulosas.setVisible(false);
                        jFrame2.setVisible(true);
                        jFrame2.setSize(420, 323);
                        seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                    }else{
                    JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                    puntuacionJ1 = puntuacionJ1 - 4;
                    puntuacionJ1F4.setText(""+puntuacionJ1);

                    jTextField3.setText(nombre2);
                    respondioMal1 = true;
                    jTextField15.setText(nombre2);
                }
                } 
            }
            if (NombreEnJuego.equals(nombre2)){// jugador 2
                            
                        if(jRadioButton4.isSelected()){
                        String respuestaU = jRadioButton4.getText();

                        if (respuestaU.equals(respuestaCorrectaNebulosa)){
                            JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                            puntuacionJ2 = puntuacionJ2 + 10;
                            puntuacionJ2F4.setText(""+puntuacionJ2);

                            jTextField3.setText(nombre1);
                            jTextField15.setText(nombre1);
                            FrameNebulosas.setVisible(false);
                            jFrame2.setVisible(true);
                            jFrame2.setSize(420, 323);
                            seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                        }else{
                        JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                        puntuacionJ2 = puntuacionJ2 - 4;
                        puntuacionJ2F4.setText(""+puntuacionJ2);

                        jTextField3.setText(nombre1);
                        respondioMal2 = true;
                        jTextField15.setText(nombre1);
                    }
                    }

                    if(jRadioButton5.isSelected()){
                        String respuestaU = jRadioButton5.getText();

                        if (respuestaU.equals(respuestaCorrectaNebulosa)){
                            JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                            puntuacionJ2 = puntuacionJ2 + 10;
                            puntuacionJ2F4.setText(""+puntuacionJ2);

                            jTextField3.setText(nombre1);
                            jTextField15.setText(nombre1);
                            FrameNebulosas.setVisible(false);
                            jFrame2.setVisible(true);
                            jFrame2.setSize(420, 323);
                            seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                        }else{
                        JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                        puntuacionJ2 = puntuacionJ2 - 4;
                        puntuacionJ2F4.setText(""+puntuacionJ2);

                        jTextField3.setText(nombre1);
                        respondioMal2 = true;
                        jTextField15.setText(nombre1);
                    }
                    } 

                    if(jRadioButton6.isSelected()){
                        String respuestaU = jRadioButton6.getText();

                        if (respuestaU.equals(respuestaCorrectaNebulosa)){
                            JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                            puntuacionJ2 = puntuacionJ2 + 10;
                            puntuacionJ2F4.setText(""+puntuacionJ2);

                            jTextField3.setText(nombre1);
                            jTextField15.setText(nombre1);
                            FrameNebulosas.setVisible(false);
                            jFrame2.setVisible(true);
                            jFrame2.setSize(420, 323);
                            seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                        }else{
                        JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                        puntuacionJ2 = puntuacionJ2 - 4;
                        puntuacionJ2F4.setText(""+puntuacionJ2);

                        jTextField3.setText(nombre1);
                        respondioMal2 = true;
                        jTextField15.setText(nombre1);
                    }
                    }
            }
            
        
        if (contadorBotones == 2){ // subir la ronda cada 2 turnos
            contadorTurno = contadorTurno + 1;
            jLabel6.setText("Ronda "+contadorTurno);
            contadorBotones = 0;
        }
        if (respondioMal1 && respondioMal2){ // respondieron mal los 2
            JOptionPane.showMessageDialog(null, "Los dos respondieron mal la pregunta.");
            JOptionPane.showMessageDialog(null, "La respuesta correcta era " + respuestaCorrectaEstrella +"!");
                FrameNebulosas.setVisible(false);
                
                if (NombreEnJuego.equals(nombre1)){
                    jTextField3.setText(nombre2);
                    jTextField4.setText(nombre2);
                }
                if (NombreEnJuego.equals(nombre2)){
                    jTextField3.setText(nombre1);
                    jTextField4.setText(nombre1);
                }
                seleccionTurnoImpar = seleccionTurnoImpar + 1;
                jFrame2.setVisible(true);
                jFrame2.setSize(420, 323);
                if (pasa == 1){
                    jTextField3.setText(nombre2);
                    jTextField4.setText(nombre2);
                    pasa = 2;
                } else{
                    jTextField3.setText(nombre1);
                    jTextField4.setText(nombre1);
                    pasa = 1;
                }
        }
            
        
        
        if (puntuacionJ1 >= 40){
            JOptionPane.showMessageDialog(null, "El jugador 1 ha ganado!");
            FrameNebulosas.setVisible(false);
            jFrame2.setVisible(false);
            InterfazGrafica frame = new InterfazGrafica();
            frame.setVisible(true);
        }
        if (puntuacionJ2 >= 40){
            JOptionPane.showMessageDialog(null, "El jugador 2 ha ganado!");
            FrameNebulosas.setVisible(false);
            jFrame2.setVisible(false);
            InterfazGrafica frame = new InterfazGrafica();
            frame.setVisible(true);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
    String NombreEnJuego = jTextField18.getText();
        
        if (NombreEnJuego.equals(nombre1)){ //jugador 1
                if(jRadioButton7.isSelected()){
                    String respuestaU = jRadioButton7.getText();

                    if (respuestaU.equals(respuestaCorrectaPlaneta)){
                        JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                        puntuacionJ1 = puntuacionJ1 + 10;
                        puntuacionJ1F5.setText(""+puntuacionJ1);

                        jTextField3.setText(nombre2);
                        jTextField18.setText(nombre2);
                        FramePlanetas.setVisible(false);
                        jFrame2.setVisible(true);
                        jFrame2.setSize(420, 323);
                        seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                    }else{
                    JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                    puntuacionJ1 = puntuacionJ1 - 4;
                    puntuacionJ1F5.setText(""+puntuacionJ1);

                    jTextField3.setText(nombre2);
                    respondioMal1 = true;
                    jTextField18.setText(nombre2);
                }
                }

                if(jRadioButton8.isSelected()){
                    String respuestaU = jRadioButton8.getText();

                    if (respuestaU.equals(respuestaCorrectaPlaneta)){
                        JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                        puntuacionJ1 = puntuacionJ1 + 10;
                        puntuacionJ1F5.setText(""+puntuacionJ1);

                        jTextField3.setText(nombre2);
                        jTextField18.setText(nombre2);
                        FramePlanetas.setVisible(false);
                        jFrame2.setVisible(true);
                        jFrame2.setSize(420, 323);
                        seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                    }else{
                    JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                    puntuacionJ1 = puntuacionJ1 - 4;
                    puntuacionJ1F5.setText(""+puntuacionJ1);

                    jTextField3.setText(nombre2);
                    respondioMal1 = true;
                    jTextField18.setText(nombre2);
                }
                } 

                if(jRadioButton9.isSelected()){
                    String respuestaU = jRadioButton9.getText();

                    if (respuestaU.equals(respuestaCorrectaPlaneta)){
                        JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                        puntuacionJ1 = puntuacionJ1 + 10;
                        puntuacionJ1F5.setText(""+puntuacionJ1);

                        jTextField3.setText(nombre2);
                        jTextField18.setText(nombre2);
                        FramePlanetas.setVisible(false);
                        jFrame2.setVisible(true);
                        jFrame2.setSize(420, 323);
                        seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                    }else{
                    JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                    puntuacionJ1 = puntuacionJ1 - 4;
                    puntuacionJ1F5.setText(""+puntuacionJ1);

                    jTextField3.setText(nombre2);
                    respondioMal1 = true;
                    jTextField18.setText(nombre2);
                }
                } 
            }
            if (NombreEnJuego.equals(nombre2)){// jugador 2
                            
                        if(jRadioButton7.isSelected()){
                        String respuestaU = jRadioButton7.getText();

                        if (respuestaU.equals(respuestaCorrectaPlaneta)){
                            JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                            puntuacionJ2 = puntuacionJ2 + 10;
                            puntuacionJ2F5.setText(""+puntuacionJ2);

                            jTextField3.setText(nombre1);
                            jTextField18.setText(nombre1);
                            FramePlanetas.setVisible(false);
                            jFrame2.setVisible(true);
                            jFrame2.setSize(420, 323);
                            seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                        }else{
                        JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                        puntuacionJ2 = puntuacionJ2 - 4;
                        puntuacionJ2F5.setText(""+puntuacionJ2);

                        jTextField3.setText(nombre1);
                        respondioMal2 = true;
                        jTextField18.setText(nombre1);
                    }
                    }

                    if(jRadioButton8.isSelected()){
                        String respuestaU = jRadioButton8.getText();

                        if (respuestaU.equals(respuestaCorrectaPlaneta)){
                            JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                            puntuacionJ2 = puntuacionJ2 + 10;
                            puntuacionJ2F5.setText(""+puntuacionJ2);

                            jTextField3.setText(nombre1);
                            jTextField18.setText(nombre1);
                            FramePlanetas.setVisible(false);
                            jFrame2.setVisible(true);
                            jFrame2.setSize(420, 323);
                            seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                        }else{
                        JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                        puntuacionJ2 = puntuacionJ2 - 4;
                        puntuacionJ2F5.setText(""+puntuacionJ2);

                        jTextField3.setText(nombre1);
                        respondioMal2 = true;
                        jTextField18.setText(nombre1);
                    }
                    } 

                    if(jRadioButton9.isSelected()){
                        String respuestaU = jRadioButton9.getText();

                        if (respuestaU.equals(respuestaCorrectaPlaneta)){
                            JOptionPane.showMessageDialog(null,"Has acertado a la respuesta! +10 puntos");
                            puntuacionJ2 = puntuacionJ2 + 10;
                            puntuacionJ2F5.setText(""+puntuacionJ2);

                            jTextField3.setText(nombre1);
                            jTextField18.setText(nombre1);
                            FramePlanetas.setVisible(false);
                            jFrame2.setVisible(true);
                            jFrame2.setSize(420, 323);
                            seleccionTurnoImpar = seleccionTurnoImpar + 1; 

                        }else{
                        JOptionPane.showMessageDialog(null,"Has respondido mal. -4 puntos");
                        puntuacionJ2 = puntuacionJ2 - 4;
                        puntuacionJ2F5.setText(""+puntuacionJ2);

                        jTextField3.setText(nombre1);
                        respondioMal2 = true;
                        jTextField18.setText(nombre1);
                    }
                    }
            }
            
        
        if (contadorBotones == 2){ // subir la ronda cada 2 turnos
            contadorTurno = contadorTurno + 1;
            jLabel6.setText("Ronda "+contadorTurno);
            contadorBotones = 0;
        }
        if (respondioMal1 && respondioMal2){ // respondieron mal los 2
            JOptionPane.showMessageDialog(null, "Los dos respondieron mal la pregunta.");
            JOptionPane.showMessageDialog(null, "La respuesta correcta era " + respuestaCorrectaPlaneta +"!");
                FramePlanetas.setVisible(false);
                
                if (NombreEnJuego.equals(nombre1)){
                    jTextField3.setText(nombre2);
                    jTextField18.setText(nombre2);
                }
                if (NombreEnJuego.equals(nombre2)){
                    jTextField3.setText(nombre1);
                    jTextField18.setText(nombre1);
                }
                seleccionTurnoImpar = seleccionTurnoImpar + 1;
                jFrame2.setVisible(true);
                jFrame2.setSize(420, 323);
                if (pasa == 1){
                    jTextField3.setText(nombre2);
                    jTextField18.setText(nombre2);
                    pasa = 2;
                } else{
                    jTextField3.setText(nombre1);
                    jTextField18.setText(nombre1);
                    pasa = 1;
                }
        }
            
        
        
        if (puntuacionJ1 >= 40){
            JOptionPane.showMessageDialog(null, "El jugador 1 ha ganado!");
            FramePlanetas.setVisible(false);
            jFrame2.setVisible(false);
            InterfazGrafica frame = new InterfazGrafica();
            frame.setVisible(true);
        }
        if (puntuacionJ2 >= 40){
            JOptionPane.showMessageDialog(null, "El jugador 2 ha ganado!");
            FramePlanetas.setVisible(false);
            jFrame2.setVisible(false);
            InterfazGrafica frame = new InterfazGrafica();
            frame.setVisible(true);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        this.setVisible(false);
        InterfazGrafica frame = new InterfazGrafica();
        frame.setVisible(true);
        Información.setVisible(false);
    }//GEN-LAST:event_RegresarActionPerformed

    private void VerInforEstreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerInforEstreActionPerformed
       initComp();
       Paginas=0;
       Información.setVisible(false);
       InformaciónEstrellas.setVisible(true);
       InformaciónEstrellas.setSize(770, 420);
       EstrellasNombre.setText(estrellas[Paginas].getNombre());
       EstrellasTipo.setText(estrellas[Paginas].getTipo());
       EstrellasDistanciaT.setText(estrellas[Paginas].getDistanciaTierra()+"");
       EstrellasConstelación.setText(estrellas[Paginas].getConstelacion());
       EstrellasLuminosidad.setText(estrellas[Paginas].getluminosidad()+"");
    }//GEN-LAST:event_VerInforEstreActionPerformed

    private void VerInfoPlaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerInfoPlaneActionPerformed
       initComp();
       Paginas=0;
       Información.setVisible(false);
       InformaciónPlanetas.setVisible(true);
       InformaciónPlanetas.setSize(780, 500); 
       PlanetaNombre.setText(planetas[Paginas].getNombre());
       PlanetaTipo.setText(planetas[Paginas].getTipo());
       PlanetaDistancia.setText(planetas[Paginas].getDistanciaTierra()+"");
       PlanetaTemp.setText(planetas[Paginas].getTempMin()+"");
       PlanetaRotacion.setText(planetas[Paginas].getRotacion()+"");
       PlanetaTraslacion.setText(planetas[Paginas].getTraslacion());  
    }//GEN-LAST:event_VerInfoPlaneActionPerformed

    private void EstrellasDistanciaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstrellasDistanciaTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstrellasDistanciaTActionPerformed

    private void EstrellasNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstrellasNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstrellasNombreActionPerformed

    private void RegresarInfoEstreAInfoGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarInfoEstreAInfoGenActionPerformed
        Información.setVisible(true);
        InformaciónEstrellas.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_RegresarInfoEstreAInfoGenActionPerformed

    private void AgregarEstrellasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarEstrellasActionPerformed
        InformaciónEstrellas.setVisible(false);
        EstrellasNombre1.setText("");
        EstrellasTipo1.setText("");
        EstrellasDistanciaT1.setText("");
        EstrellasConstelación1.setText("");
        EstrellasLuminosidad1.setText("");
        AgregaciónEstrellas.setSize(770, 420);
        AgregaciónEstrellas.setVisible(true);
    }//GEN-LAST:event_AgregarEstrellasActionPerformed

    private void AvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvanzarActionPerformed
       initComp();
       Paginas++;
       if(Paginas<numeroEstrellas){
            InformaciónEstrellas.setVisible(false);       
            
            EstrellasNombre.setText(estrellas[Paginas].getNombre());
            EstrellasTipo.setText(estrellas[Paginas].getTipo());
            EstrellasDistanciaT.setText(estrellas[Paginas].getDistanciaTierra()+"");
            EstrellasConstelación.setText(estrellas[Paginas].getConstelacion());
            EstrellasLuminosidad.setText(estrellas[Paginas].getluminosidad()+"");
            InformaciónEstrellas.setVisible(true);
       }else{
           Paginas--;
           JOptionPane.showMessageDialog(null,"Ya no hay más Estrellas");
       }
       
    }//GEN-LAST:event_AvanzarActionPerformed

    private void RegresarPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarPaginaActionPerformed
        initComp();
       Paginas--;
       if(Paginas>=0){
            InformaciónEstrellas.setVisible(false);       
 
            EstrellasNombre.setText(estrellas[Paginas].getNombre());
            EstrellasTipo.setText(estrellas[Paginas].getTipo());
            EstrellasDistanciaT.setText(estrellas[Paginas].getDistanciaTierra()+"");
            EstrellasConstelación.setText(estrellas[Paginas].getConstelacion());
            EstrellasLuminosidad.setText(estrellas[Paginas].getluminosidad()+"");
            InformaciónEstrellas.setVisible(true);
       }else{
           Paginas++;
           JOptionPane.showMessageDialog(null,"Ya no hay más Estrellas");
       }        
    }//GEN-LAST:event_RegresarPaginaActionPerformed

    private void EstrellasNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstrellasNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstrellasNombre1ActionPerformed

    private void EstrellasDistanciaT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstrellasDistanciaT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstrellasDistanciaT1ActionPerformed

    private void AgregarEstrellas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarEstrellas1ActionPerformed
       initComp();
    
       if(EstrellasNombre1.getText().equals("")||EstrellasTipo1.getText().equals("")||EstrellasDistanciaT1.getText().equals("")||EstrellasConstelación1.getText().equals("")||EstrellasLuminosidad1.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Se tienen que rellenar todos los datos");
       }else{
           try{
                estrellas[numeroEstrellas]=new Estrellas();
                estrellas[numeroEstrellas].setNombre(EstrellasNombre1.getText());
                estrellas[numeroEstrellas].setTipo(EstrellasTipo1.getText()); 
                estrellas[numeroEstrellas].setDistanciaTierra(Long.parseLong(EstrellasDistanciaT1.getText()));
                estrellas[numeroEstrellas].setConstelacion(EstrellasConstelación1.getText());
                estrellas[numeroEstrellas].setluminosidad( Integer.parseInt(EstrellasLuminosidad1.getText())); 
                numeroEstrellas++;
                JOptionPane.showMessageDialog(null,"Nueva Estrella Agregada");
           }catch(NumberFormatException e){
                AgregaciónEstrellas.setVisible(false);
                EstrellasNombre1.setText("");
                EstrellasTipo1.setText("");
                EstrellasDistanciaT1.setText("");
                EstrellasConstelación1.setText("");
                EstrellasLuminosidad1.setText("");
                AgregaciónEstrellas.setVisible(true);
                JOptionPane.showMessageDialog(null,"Tipo de Dato erroneo");
           }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error Desconociso");
           }
           
       }
    }//GEN-LAST:event_AgregarEstrellas1ActionPerformed

    private void RegresarInfoEstreAInfoGen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarInfoEstreAInfoGen1ActionPerformed
        AgregaciónEstrellas.setVisible(false);
        InformaciónEstrellas.setVisible(true);       
    }//GEN-LAST:event_RegresarInfoEstreAInfoGen1ActionPerformed

    private void PlanetaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlanetaNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlanetaNombreActionPerformed

    private void PlanetaDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlanetaDistanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlanetaDistanciaActionPerformed

    private void Avanzar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Avanzar1ActionPerformed
        initComp();
        Paginas++;
        if(Paginas<numeroPlanetas){
            InformaciónPlanetas.setVisible(false);       
            PlanetaNombre.setText(planetas[Paginas].getNombre());
            PlanetaTipo.setText(planetas[Paginas].getTipo());
            PlanetaDistancia.setText(planetas[Paginas].getDistanciaTierra()+"");
            PlanetaTemp.setText(planetas[Paginas].getTempMin()+"");
            PlanetaRotacion.setText(planetas[Paginas].getRotacion()+"");
            PlanetaTraslacion.setText(planetas[Paginas].getTraslacion());  
            InformaciónPlanetas.setVisible(true);
       }else{
           Paginas--;
           JOptionPane.showMessageDialog(null,"Ya no hay más Planetas");
       }                 
    }//GEN-LAST:event_Avanzar1ActionPerformed

    private void RegresarPagina1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarPagina1ActionPerformed
         initComp();
        Paginas--;
        if(Paginas>=0){
            InformaciónPlanetas.setVisible(false);       
            PlanetaNombre.setText(planetas[Paginas].getNombre());
            PlanetaTipo.setText(planetas[Paginas].getTipo());
            PlanetaDistancia.setText(planetas[Paginas].getDistanciaTierra()+"");
            PlanetaTemp.setText(planetas[Paginas].getTempMin()+"");
            PlanetaRotacion.setText(planetas[Paginas].getRotacion()+"");
            PlanetaTraslacion.setText(planetas[Paginas].getTraslacion());  
            InformaciónPlanetas.setVisible(true);
       }else{
           Paginas++;
           JOptionPane.showMessageDialog(null,"Ya no hay más Planetas");
       }               
    }//GEN-LAST:event_RegresarPagina1ActionPerformed

    private void AgregarPlanetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPlanetaActionPerformed
        InformaciónPlanetas.setVisible(false);
        PlanetaNombre1.setText("");
        PlanetaTipo1.setText("");
        PlanetaDistancia1.setText("");
        PlanetaTemp1.setText("");
        PlanetaRotacion1.setText("");
        PlanetaTraslacion1.setText("");  
        AgregaciónPlanetas.setSize(780, 500);
        AgregaciónPlanetas.setVisible(true);        
    }//GEN-LAST:event_AgregarPlanetaActionPerformed

    private void RegresarInfoPlaneAInfoGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarInfoPlaneAInfoGenActionPerformed
        Información.setVisible(true);
        InformaciónPlanetas.setVisible(false);     
    }//GEN-LAST:event_RegresarInfoPlaneAInfoGenActionPerformed

    private void PlanetaNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlanetaNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlanetaNombre1ActionPerformed

    private void PlanetaDistancia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlanetaDistancia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlanetaDistancia1ActionPerformed

    private void AgregarPlaneta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPlaneta1ActionPerformed
      initComp();

       if(PlanetaNombre1.getText().equals("")||PlanetaTipo1.getText().equals("")||PlanetaDistancia1.getText().equals("")||PlanetaTemp1.getText().equals("")||PlanetaRotacion1.getText().equals("")||PlanetaTraslacion1.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Se tienen que rellenar todos los datos");
       }else{
           try{
               planetas[numeroPlanetas]= new Planetas();
                planetas[numeroPlanetas].setNombre(PlanetaNombre1.getText());
                planetas[numeroPlanetas].setTipo(PlanetaTipo1.getText());
                planetas[numeroPlanetas].setDistanciaTierra(Long.parseLong(PlanetaDistancia1.getText()));
                planetas[numeroPlanetas].setTempMin(Integer.parseInt(PlanetaTemp1.getText()));
                planetas[numeroPlanetas].setRotacion(Integer.parseInt(PlanetaRotacion1.getText()));
                planetas[numeroPlanetas].setTraslacion(PlanetaTraslacion1.getText());
                numeroPlanetas++;
                JOptionPane.showMessageDialog(null,"Nuevo Planeta Agregado");
           }catch(NumberFormatException e){
                AgregaciónPlanetas.setVisible(false);
                PlanetaNombre1.setText("");
                PlanetaTipo1.setText("");
                PlanetaDistancia1.setText("");
                PlanetaTemp1.setText("");
                PlanetaRotacion1.setText("");
                PlanetaTraslacion1.setText("");  
                AgregaciónPlanetas.setVisible(true);
                JOptionPane.showMessageDialog(null,"Tipo de Dato erroneo");
           }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error Desconociso");
           }
           
       }       
    }//GEN-LAST:event_AgregarPlaneta1ActionPerformed

    private void RegresarInfoPlaneAInfoGen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarInfoPlaneAInfoGen1ActionPerformed
       AgregaciónPlanetas.setVisible(false);
        InformaciónPlanetas.setVisible(true);       
    }//GEN-LAST:event_RegresarInfoPlaneAInfoGen1ActionPerformed

    private void NebulosaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NebulosaNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NebulosaNombreActionPerformed

    private void NebulosaConstelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NebulosaConstelacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NebulosaConstelacionActionPerformed

    private void Avanzar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Avanzar2ActionPerformed
        initComp();
        Paginas++;
        if(Paginas<numeroNebulosas){
            InformaciónNebulosas.setVisible(false);       
            NebulosaNombre.setText(nebulosas[Paginas].getNombre());
            NebulosaTipo.setText(nebulosas[Paginas].getTipo());
            NebulosaConstelacion.setText(nebulosas[Paginas].getConstelacion());
            NebulosaTemp.setText(nebulosas[Paginas].getTempMin()+"");
            NebulosaAñoDescubrimiento.setText(nebulosas[Paginas].getAñoDescubrimiento()+"");
            InformaciónNebulosas.setVisible(true);
       }else{
           Paginas--;
           JOptionPane.showMessageDialog(null,"Ya no hay más Nebulosas");
       }           
    }//GEN-LAST:event_Avanzar2ActionPerformed

    private void RegresarPagina2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarPagina2ActionPerformed
        initComp();
        Paginas--;
        if(Paginas>=0){
            InformaciónNebulosas.setVisible(false);       
            NebulosaNombre.setText(nebulosas[Paginas].getNombre());
            NebulosaTipo.setText(nebulosas[Paginas].getTipo());
            NebulosaConstelacion.setText(nebulosas[Paginas].getConstelacion());
            NebulosaTemp.setText(nebulosas[Paginas].getTempMin()+"");
            NebulosaAñoDescubrimiento.setText(nebulosas[Paginas].getAñoDescubrimiento()+"");
            InformaciónNebulosas.setVisible(true);
       }else{
           Paginas++;
           JOptionPane.showMessageDialog(null,"Ya no hay más Nebulosas");
       }           
    }//GEN-LAST:event_RegresarPagina2ActionPerformed

    private void AgregarNebulosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarNebulosaActionPerformed
        InformaciónNebulosas.setVisible(false);
        NebulosaNombre1.setText("");
        NebulosaTipo1.setText("");
        NebulosaConstelacion1.setText("");
        NebulosaTemp1.setText("");
        NebulosaAñoDescubrimiento1.setText("");
        AgregaciónNebulosas.setSize(740, 400);
        AgregaciónNebulosas.setVisible(true);        
    }//GEN-LAST:event_AgregarNebulosaActionPerformed

    private void RegresarInfoNebuAInfoGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarInfoNebuAInfoGenActionPerformed
        Información.setVisible(true);
        InformaciónNebulosas.setVisible(false); 
    }//GEN-LAST:event_RegresarInfoNebuAInfoGenActionPerformed

    private void VerInfoNebuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerInfoNebuActionPerformed
        initComp();
        Paginas=0;
        Información.setVisible(false);
        InformaciónNebulosas.setVisible(true);
        InformaciónNebulosas.setSize(780, 440); 
        NebulosaNombre.setText(nebulosas[Paginas].getNombre());
        NebulosaTipo.setText(nebulosas[Paginas].getTipo());
        NebulosaConstelacion.setText(nebulosas[Paginas].getConstelacion());
        NebulosaTemp.setText(nebulosas[Paginas].getTempMin()+"");
        NebulosaAñoDescubrimiento.setText(nebulosas[Paginas].getAñoDescubrimiento()+"");

    }//GEN-LAST:event_VerInfoNebuActionPerformed

    private void NebulosaNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NebulosaNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NebulosaNombre1ActionPerformed

    private void NebulosaConstelacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NebulosaConstelacion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NebulosaConstelacion1ActionPerformed

    private void AgregarNebulosa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarNebulosa1ActionPerformed
        initComp();
         
       if(NebulosaNombre1.getText().equals("")||NebulosaTipo1.getText().equals("")||NebulosaConstelacion1.getText().equals("")||NebulosaTemp1.getText().equals("")||NebulosaAñoDescubrimiento1.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Se tienen que rellenar todos los datos");
       }else{
           try{
                nebulosas[numeroNebulosas]= new Nebulosa();
                nebulosas[numeroNebulosas].setNombre(NebulosaNombre1.getText());
                nebulosas[numeroNebulosas].setTipo(NebulosaTipo1.getText());
                nebulosas[numeroNebulosas].setConstelacion(NebulosaConstelacion1.getText());
                nebulosas[numeroNebulosas].setTempMin(Integer.parseInt(NebulosaTemp1.getText()));
                nebulosas[numeroNebulosas].setAñoDescubrimiento(Integer.parseInt(NebulosaAñoDescubrimiento1.getText()));       
                numeroNebulosas++;
                JOptionPane.showMessageDialog(null,"Nueva Nebulosa Agregada");
           }catch(NumberFormatException e){
                AgregaciónNebulosas.setVisible(false);
                NebulosaNombre1.setText("");
                NebulosaTipo1.setText("");
                NebulosaConstelacion1.setText("");
                NebulosaTemp1.setText("");
                NebulosaAñoDescubrimiento1.setText("");  
                AgregaciónNebulosas.setVisible(true);
                JOptionPane.showMessageDialog(null,"Tipo de Dato erroneo");
           }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error Desconociso");
           }
           
       }    
    }//GEN-LAST:event_AgregarNebulosa1ActionPerformed

    private void RegresarInfoNebuAInfoGen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarInfoNebuAInfoGen1ActionPerformed
        AgregaciónNebulosas.setVisible(false);
        InformaciónNebulosas.setVisible(true);       
    }//GEN-LAST:event_RegresarInfoNebuAInfoGen1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame AgregaciónEstrellas;
    private javax.swing.JFrame AgregaciónNebulosas;
    private javax.swing.JFrame AgregaciónPlanetas;
    private javax.swing.JButton AgregarEstrellas;
    private javax.swing.JButton AgregarEstrellas1;
    private javax.swing.JButton AgregarNebulosa;
    private javax.swing.JButton AgregarNebulosa1;
    private javax.swing.JButton AgregarPlaneta;
    private javax.swing.JButton AgregarPlaneta1;
    private javax.swing.JButton Avanzar;
    private javax.swing.JButton Avanzar1;
    private javax.swing.JButton Avanzar2;
    private javax.swing.JTextField EstrellasConstelación;
    private javax.swing.JTextField EstrellasConstelación1;
    private javax.swing.JTextField EstrellasDistanciaT;
    private javax.swing.JTextField EstrellasDistanciaT1;
    private javax.swing.JTextField EstrellasLuminosidad;
    private javax.swing.JTextField EstrellasLuminosidad1;
    private javax.swing.JTextField EstrellasNombre;
    private javax.swing.JTextField EstrellasNombre1;
    private javax.swing.JTextField EstrellasTipo;
    private javax.swing.JTextField EstrellasTipo1;
    private javax.swing.JFrame FrameEstrellas;
    private javax.swing.JFrame FrameNebulosas;
    private javax.swing.JFrame FramePlanetas;
    private javax.swing.JFrame Información;
    private javax.swing.JFrame InformaciónEstrellas;
    private javax.swing.JFrame InformaciónNebulosas;
    private javax.swing.JFrame InformaciónPlanetas;
    private javax.swing.JTextField NebulosaAñoDescubrimiento;
    private javax.swing.JTextField NebulosaAñoDescubrimiento1;
    private javax.swing.JTextField NebulosaConstelacion;
    private javax.swing.JTextField NebulosaConstelacion1;
    private javax.swing.JTextField NebulosaNombre;
    private javax.swing.JTextField NebulosaNombre1;
    private javax.swing.JTextField NebulosaTemp;
    private javax.swing.JTextField NebulosaTemp1;
    private javax.swing.JTextField NebulosaTipo;
    private javax.swing.JTextField NebulosaTipo1;
    private javax.swing.JTextField PlanetaDistancia;
    private javax.swing.JTextField PlanetaDistancia1;
    private javax.swing.JTextField PlanetaNombre;
    private javax.swing.JTextField PlanetaNombre1;
    private javax.swing.JTextField PlanetaRotacion;
    private javax.swing.JTextField PlanetaRotacion1;
    private javax.swing.JTextField PlanetaTemp;
    private javax.swing.JTextField PlanetaTemp1;
    private javax.swing.JTextField PlanetaTipo;
    private javax.swing.JTextField PlanetaTipo1;
    private javax.swing.JTextField PlanetaTraslacion;
    private javax.swing.JTextField PlanetaTraslacion1;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton RegresarInfoEstreAInfoGen;
    private javax.swing.JButton RegresarInfoEstreAInfoGen1;
    private javax.swing.JButton RegresarInfoNebuAInfoGen;
    private javax.swing.JButton RegresarInfoNebuAInfoGen1;
    private javax.swing.JButton RegresarInfoPlaneAInfoGen;
    private javax.swing.JButton RegresarInfoPlaneAInfoGen1;
    private javax.swing.JButton RegresarPagina;
    private javax.swing.JButton RegresarPagina1;
    private javax.swing.JButton RegresarPagina2;
    private javax.swing.JLabel Respuesta2;
    private javax.swing.JLabel Respuesta3;
    private javax.swing.JLabel Respuesta4;
    private javax.swing.JButton VerInfoNebu;
    private javax.swing.JButton VerInfoPlane;
    private javax.swing.JButton VerInforEstre;
    private java.awt.Button buttonExit;
    private javax.swing.ButtonGroup buttonGroup1;
    private java.awt.Button buttonInfo;
    private java.awt.Button buttonPlay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel labelPregunta2;
    private javax.swing.JLabel labelPregunta3;
    private javax.swing.JLabel labelPregunta4;
    private javax.swing.JLabel nombreEstrella;
    private javax.swing.JLabel nombreEstrella1;
    private javax.swing.JLabel nombreEstrella2;
    private javax.swing.JLabel pregunta;
    private javax.swing.JLabel pregunta1;
    private javax.swing.JLabel pregunta2;
    private javax.swing.JLabel puntuacionJ1F3;
    private javax.swing.JLabel puntuacionJ1F4;
    private javax.swing.JLabel puntuacionJ1F5;
    private javax.swing.JLabel puntuacionJ2F3;
    private javax.swing.JLabel puntuacionJ2F4;
    private javax.swing.JLabel puntuacionJ2F5;
    // End of variables declaration//GEN-END:variables
}
