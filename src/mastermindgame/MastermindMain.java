package mastermindgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MastermindMain extends javax.swing.JFrame {
    
    //Creating my own colors
    Color myOrange = new Color(255, 127, 0);
    Color purple = new Color(182, 54, 245);
    Color myPink = new Color(255, 0, 204);
    Color background = new Color(51, 51, 51);
    
    //Creating my own font
    Font font = new Font("Impact", Font.PLAIN, 42);
    
    //Declaring graphics
    Graphics2D gfx;
    
    //Declaring the different colours
    String [] colorArray = {"red", "orange", "yellow", "green", "blue", "magenta", "pink", "white"};
    
    //Declaring passcode
    String color1;
    String color2;
    String color3;
    String color4;
    
    //Initializing user guesses
    String guess1 = "";
    String guess2 = "";
    String guess3 = "";
    String guess4 = "";
    
    //Initializing and declaring multiplayer player scores
    double player1Score = 0;
    double player2Score = 0;
    
    //Other variables that help with guessing/drawing process
    int guessNumber = 0;
    int length = 300;
    int line;
    int radius = 50;
    
    //Initializing number of right colours and right spots
    int rightColors = 0;
    int rightSpots = 0;
    
    //Initializing booleans that make sure that one color doesn't get accounted for twice
    boolean color1Guessed = false;
    boolean color2Guessed = false;
    boolean color3Guessed = false;
    boolean color4Guessed = false;
    
    boolean guess1Guessed = false;
    boolean guess2Guessed = false;
    boolean guess3Guessed = false;
    boolean guess4Guessed = false;
    
    //Boolean that tells the computer when to start erasing lines after going back to the top of the screen
    boolean nowErasing = false;
    
    //Declaring variables that help with the timer
    Object settings;
    int millis = 0;
    int secs = 0;
    int mins = 0;
    boolean red = false;    
    DecimalFormat df = new DecimalFormat("00");
    
    //Declaring a boolean in place of playerState
    boolean single;
    
    public MastermindMain(){
        initComponents();
    }
    
    /**
     * Method that prints a dot of the correct colour, and saves that colour as the user's guess
     * @param sColor the colour (String)
     * @param gColor the colour (Color)
     * @return None
     */
    void guessColour(String sColor, Color gColor){
        if (length <= 750){
            gfx.setColor(gColor);
            gfx.fillOval(length, line, radius, radius); 

            switch (length)
                {
                    case 300://if first guess
                        guess1 = sColor;
                        break;
                    case 450://if second guess
                        guess2 = sColor;
                        break;
                    case 600://if second last guess 
                        guess3 = sColor;
                        break; 
                    case 750://if last guess 
                        guess4 = sColor;
                        break; 
                }
            guessNumber++;
            length = length + 150;
        }
    }
    
    /**
     * Method that draws out the pass code 
     * @param FirstColor first colour in the pass code
     * @param SecondColor second colour in the pass code
     * @param ThirdColor third colour in the pass code
     * @param FourthColor last colour in the pass code
     * @return None
     */
    void callPasscode(String FirstColor, String SecondColor, String ThridColor, String FourthColor){  
        String [] passcodeColors = {FirstColor, SecondColor, ThridColor, FourthColor};
        for (int i = 0; i < 4; i++){//repeat once for each dot
            switch (passcodeColors[i])
                {
                case "red":
                    gfx.setColor(Color.RED);
                    break;
                case "orange":
                    gfx.setColor(myOrange);
                    break;
                case "yellow": 
                    gfx.setColor(Color.YELLOW);
                    break; 
                case "green": 
                    gfx.setColor(Color.GREEN);
                    break; 
                case "blue":
                    gfx.setColor(Color.BLUE);
                    break;
                case "magenta":
                    gfx.setColor(purple);
                    break;
                case "pink":
                    gfx.setColor(myPink);
                    break;
                case "white":
                    gfx.setColor(Color.WHITE);
                    break;
                }
            gfx.fillOval(length, line, radius, radius);
            length = length + 150;
        }
    }
            
    public MastermindMain (boolean playerState) {//playerState
        initComponents();
        
        //Testing variables
        System.out.println("" + playerState);
        
        //decalring graphics
        gfx = (Graphics2D) pnlWindows.getGraphics();
        gfx.setFont(font);
        
        if (playerState == true){//Single Player
            //Declaring passcode
            color1 = colorArray[(int) Math.ceil(Math.random() * 8) - 1];
            color2 = colorArray[(int) Math.ceil(Math.random() * 8) - 1];
            color3 = colorArray[(int) Math.ceil(Math.random() * 8) - 1];
            color4 = colorArray[(int) Math.ceil(Math.random() * 8) - 1];
            
            //Making all correct components appear
            lblInstructions.setVisible(false);
            btnSubmit.setVisible(false);
            
            //Initializing line
            line = 40;
            
            //Initializing a new boolean in place of playerState
            single = true;
            
            //Trace passcode
            System.out.println(color1 + " " + color2 + " " + color3 + " " + color4);
        }
        else{//Multiplayer
            //Making all correct components appear
            lblInstructions.setVisible(true);
            btnGiveUp.setVisible(false);
            btnReset.setVisible(false);
            btnGuess.setVisible(false);
            cmbSettings.setVisible(false);
            btnSettings.setVisible(false);
            
            //Initializing a new boolean in place of playerState
            single = false;
            
            //Initializing line
            line = 140;
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlWindows = new javax.swing.JPanel();
        btnGreen = new javax.swing.JButton();
        btnYellow = new javax.swing.JButton();
        btnOrange = new javax.swing.JButton();
        btnBlue = new javax.swing.JButton();
        btnMagenta = new javax.swing.JButton();
        btnPink = new javax.swing.JButton();
        btnWhite = new javax.swing.JButton();
        btnGuess = new javax.swing.JButton();
        btnRed = new javax.swing.JButton();
        btnGiveUp = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cmbSettings = new javax.swing.JComboBox<>();
        btnSettings = new javax.swing.JButton();
        lblTimer = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblInstructions = new javax.swing.JLabel();
        lblQuestions = new javax.swing.JLabel();
        lblQuestions2 = new javax.swing.JLabel();
        lblQuestions3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlWindows.setBackground(new java.awt.Color(51, 51, 51));

        btnGreen.setBackground(new java.awt.Color(51, 255, 51));
        btnGreen.setForeground(new java.awt.Color(51, 255, 51));
        btnGreen.setText("Green");
        btnGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGreenActionPerformed(evt);
            }
        });

        btnYellow.setBackground(new java.awt.Color(255, 255, 0));
        btnYellow.setForeground(new java.awt.Color(255, 255, 0));
        btnYellow.setText("Yellow");
        btnYellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYellowActionPerformed(evt);
            }
        });

        btnOrange.setBackground(new java.awt.Color(255, 127, 0));
        btnOrange.setForeground(new java.awt.Color(251, 95, 0));
        btnOrange.setText("Orange");
        btnOrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrangeActionPerformed(evt);
            }
        });

        btnBlue.setBackground(new java.awt.Color(0, 51, 255));
        btnBlue.setForeground(new java.awt.Color(0, 51, 255));
        btnBlue.setText("Blue");
        btnBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueActionPerformed(evt);
            }
        });

        btnMagenta.setBackground(new java.awt.Color(182, 54, 245));
        btnMagenta.setForeground(new java.awt.Color(102, 0, 153));
        btnMagenta.setText("Purple");
        btnMagenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMagentaActionPerformed(evt);
            }
        });

        btnPink.setBackground(new java.awt.Color(255, 0, 204));
        btnPink.setForeground(new java.awt.Color(255, 0, 204));
        btnPink.setText("Pink");
        btnPink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinkActionPerformed(evt);
            }
        });

        btnWhite.setBackground(new java.awt.Color(255, 255, 255));
        btnWhite.setText("White");
        btnWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWhiteActionPerformed(evt);
            }
        });

        btnGuess.setText("Submit Guess");
        btnGuess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuessActionPerformed(evt);
            }
        });

        btnRed.setBackground(new java.awt.Color(255, 0, 0));
        btnRed.setForeground(new java.awt.Color(255, 0, 0));
        btnRed.setText("Red");
        btnRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedActionPerformed(evt);
            }
        });

        btnGiveUp.setText("Give Up");
        btnGiveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiveUpActionPerformed(evt);
            }
        });

        btnReset.setText("Play Again?");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setText("Go Back");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cmbSettings.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Timed", "Timed" }));
        cmbSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSettingsActionPerformed(evt);
            }
        });

        btnSettings.setText("Apply Settings");
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        lblTimer.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer.setText("00:00:00");

        btnBack.setText("Close");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit code");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblInstructions.setBackground(new java.awt.Color(255, 255, 255));
        lblInstructions.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        lblInstructions.setForeground(new java.awt.Color(255, 255, 255));
        lblInstructions.setText("Input The Code For Player 2 To Guess");

        lblQuestions.setBackground(new java.awt.Color(255, 255, 255));
        lblQuestions.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        lblQuestions.setForeground(new java.awt.Color(255, 255, 255));
        lblQuestions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermindgame/QuestionsMark.png"))); // NOI18N

        lblQuestions2.setBackground(new java.awt.Color(255, 255, 255));
        lblQuestions2.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        lblQuestions2.setForeground(new java.awt.Color(255, 255, 255));
        lblQuestions2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermindgame/QuestionsMark.png"))); // NOI18N

        lblQuestions3.setBackground(new java.awt.Color(255, 255, 255));
        lblQuestions3.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        lblQuestions3.setForeground(new java.awt.Color(255, 255, 255));
        lblQuestions3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mastermindgame/QuestionsMark.png"))); // NOI18N

        javax.swing.GroupLayout pnlWindowsLayout = new javax.swing.GroupLayout(pnlWindows);
        pnlWindows.setLayout(pnlWindowsLayout);
        pnlWindowsLayout.setHorizontalGroup(
            pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWindowsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlWindowsLayout.createSequentialGroup()
                        .addComponent(lblQuestions)
                        .addContainerGap(1203, Short.MAX_VALUE))
                    .addGroup(pnlWindowsLayout.createSequentialGroup()
                        .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGiveUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuess, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWindowsLayout.createSequentialGroup()
                                .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnPink, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRed, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnOrange, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMagenta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(146, 146, 146)
                        .addComponent(lblInstructions)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblQuestions2)
                        .addGap(31, 31, 31)
                        .addComponent(lblTimer)
                        .addGap(16, 16, 16))))
            .addGroup(pnlWindowsLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSettings))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblQuestions3)
                .addGap(68, 68, 68))
        );
        pnlWindowsLayout.setVerticalGroup(
            pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWindowsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlWindowsLayout.createSequentialGroup()
                        .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack)
                            .addComponent(lblInstructions)
                            .addComponent(lblTimer))
                        .addGap(9, 9, 9)
                        .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOrange, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRed, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMagenta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPink, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnGiveUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset))
                    .addComponent(lblQuestions2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuestions)
                .addGroup(pnlWindowsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlWindowsLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cmbSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSettings)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWindowsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(lblQuestions3)
                        .addGap(88, 88, 88))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWindows, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWindows, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Setting up the timer
    javax.swing.Timer timer = new javax.swing.Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            millis++;
            if (millis == 99){
                secs++;
                millis = 0;
                if (secs == 60){
                    mins++;
                    secs = 0;
                }
            }
            lblTimer.setText(df.format(mins) + ":" + df.format(secs) + ":" + df.format(millis));
            if (mins == 2){
                timer.stop();
                gfx.setColor(Color.RED);
                gfx.drawString("Time's Up!!", 1000, 300);
                lblTimer.setForeground(Color.RED);
                timer2.start();
            }
        }
    });
    
    //Setting up the second timer which makes the first one flash
    javax.swing.Timer timer2 = new javax.swing.Timer(300, new ActionListener() {
        public void actionPerformed(ActionEvent e) {    
            if (red == true){
                lblTimer.setForeground(background);
                red = false;
            }
            else if (red == false){  
                lblTimer.setForeground(Color.RED);
                red = true;
            }
        }
    });
    
    //Now user can guess different colours and have the guess display in the panel
    private void btnRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedActionPerformed
        guessColour("red", Color.RED);
    }//GEN-LAST:event_btnRedActionPerformed

    private void btnOrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrangeActionPerformed
        guessColour("orange", myOrange);
    }//GEN-LAST:event_btnOrangeActionPerformed

    private void btnYellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYellowActionPerformed
        guessColour("yellow", Color.YELLOW);
    }//GEN-LAST:event_btnYellowActionPerformed

    private void btnGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGreenActionPerformed
        guessColour("green", Color.GREEN);
    }//GEN-LAST:event_btnGreenActionPerformed

    private void btnBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueActionPerformed
        guessColour("blue", Color.BLUE);
    }//GEN-LAST:event_btnBlueActionPerformed

    private void btnMagentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMagentaActionPerformed
        guessColour("magenta", purple);
    }//GEN-LAST:event_btnMagentaActionPerformed

    private void btnPinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPinkActionPerformed
        guessColour("pink", myPink);
    }//GEN-LAST:event_btnPinkActionPerformed

    private void btnWhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWhiteActionPerformed
        guessColour("white", Color.WHITE);
    }//GEN-LAST:event_btnWhiteActionPerformed

    //When the user makes a guess
    private void btnGuessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuessActionPerformed
        if (!guess4.equals("")){//Making sure all buttons have been pressed
            try{

                //Comparing user's guess to the actual passcode
                //Checking for right spots
                if (guess1.equals(color1)){
                    rightSpots++;
                    color1Guessed = true;
                    guess1Guessed = true;
                }
                if (guess2.equals(color2)){
                    rightSpots++;
                    color2Guessed = true;
                    guess2Guessed = true;
                }
                if (guess3.equals(color3)){
                    rightSpots++;
                    color3Guessed = true;
                    guess3Guessed = true;
                }
                if (guess4.equals(color4)){
                    rightSpots++;
                    color4Guessed = true;
                    guess4Guessed = true;
                }

                //Now checking for right colours
                if (guess1.equals(color2) && color2Guessed != true && guess1Guessed != true){
                    rightColors++;
                    color2Guessed = true;
                    guess1Guessed = true;
                }
                else if (guess1.equals(color3) && color3Guessed != true && guess1Guessed != true){
                    rightColors++;
                    color3Guessed = true;
                    guess1Guessed = true;
                }
                else if (guess1.equals(color4) && color4Guessed != true && guess1Guessed != true){
                    rightColors++;
                    color4Guessed = true;
                    guess1Guessed = true;
                }

                if (guess2.equals(color1) && color1Guessed != true && guess2Guessed != true){
                    rightColors++;
                    color1Guessed = true;
                    guess2Guessed = true;
                }
                else if (guess2.equals(color3) && color3Guessed != true && guess2Guessed != true){
                    rightColors++;
                    color3Guessed = true;
                    guess2Guessed = true;
                }
                else if (guess2.equals(color4) && color4Guessed != true && guess2Guessed != true){
                    rightColors++;
                    color4Guessed = true;
                    guess2Guessed = true;
                }

                if (guess3.equals(color1) && color1Guessed != true && guess3Guessed != true){
                    rightColors++;
                    color1Guessed = true;
                    guess3Guessed = true;
                }
                else if (guess3.equals(color2) && color2Guessed != true && guess3Guessed != true){
                    rightColors++;
                    color2Guessed = true;
                    guess3Guessed = true;
                }
                else if (guess3.equals(color4) && color4Guessed != true && guess3Guessed != true){
                    rightColors++;
                    color4Guessed = true;
                    guess3Guessed = true;
                }

                if (guess4.equals(color1) && color1Guessed != true && guess4Guessed != true){
                    rightColors++;
                    color1Guessed = true;
                    guess4Guessed = true;
                }
                else if (guess4.equals(color2) && color2Guessed != true && guess4Guessed != true){
                    rightColors++;
                    color2Guessed = true;
                    guess4Guessed = true;
                }
                else if (guess4.equals(color3) && color3Guessed != true && guess4Guessed != true){
                    rightColors++;
                    color3Guessed = true;
                    guess4Guessed = true;
                }

                //If guess is correct - telling user and getting scores
                if (guess1.equals(color1) && guess2.equals(color2) && guess3.equals(color3) && guess4.equals(color4)){
                    gfx.setColor(Color.GREEN);
                    gfx.drawString("YOU GUESSED IT!", 1000, 450);
                    
                    //Stop timer if it's running
                    try {
                        timer.stop();
                        timer2.stop();
                    } catch (Exception e){
                    }

                    //Player scores comparision system
                    if (single != true){//If in multiplayer
                        if (player2Score == 0){//Player 2's turn
                            player2Score = mins*60 + secs + millis*0.001;
                            lblInstructions.setText("Input The Code For Player 1 To Guess");
                        }
                        else{//Player 2 has already had a turn and their time has been inputted
                            player1Score = mins*60 + secs + millis*0.001;
                            if (player1Score == Math.min(player1Score, player2Score) && player2Score == Math.min(player1Score, player2Score))
                                gfx.drawString("It was a tie!", 1000, 520);
                            else if (player1Score == Math.min(player1Score, player2Score))
                                gfx.drawString("Player 1's time was better!", 875, 520); 
                            else if (player2Score == Math.min(player1Score, player2Score))
                                gfx.drawString("Player 2's time was better!", 875, 520);
                            
                            player1Score = 0;
                            player2Score = 0;
                            
                            lblInstructions.setText("Input The Code For Player 2 To Guess");
                        }
                        
                    }
                    
                }
                //If guess is incorrect - giving feedback
                else {
                    gfx.setColor(Color.WHITE);
                    gfx.drawString("" + rightColors, 250, line + (radius/2) + 15);
                    gfx.setColor(Color.RED);
                    gfx.drawString("" + rightSpots, 800 + radius, line + (radius/2) + 15);
                    
                    //Preparing to print a new line
                    if (line == 760){//if its the last line this will start back up at the top
                        line = 40;//start at the top again
                        //Clearing the next line in the panel
                        gfx.setColor(background);
                        gfx.fillRect(200, line, 750, 70);
                        nowErasing = true;
                    }
                    else if (nowErasing == true){//if the computer needs to erase the next line before continuing  
                        line = line + radius + 30;
                        //Clearing the next line in the panel
                        gfx.setColor(background);
                        gfx.fillRect(200, line, 750, 70);
                    }
                    else//printing a new line
                        line = line + radius + 30;

                    //Preparing to print a new line
                    guessNumber = 0;
                    length = 300;
                }
                //Resetting all the variables
                rightColors = 0;
                rightSpots = 0;

                color1Guessed = false;
                color2Guessed = false;
                color3Guessed = false;
                color4Guessed = false;

                guess1Guessed = false;
                guess2Guessed = false;
                guess3Guessed = false;
                guess4Guessed = false;

                guess1 = "";
                guess2 = "";
                guess3 = "";
                guess4 = "";
            } catch (Exception eError){
            }
        }
    }//GEN-LAST:event_btnGuessActionPerformed

    private void btnGiveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiveUpActionPerformed
        //Preparing to print a new line
        guessNumber = 0;
        length = 300;
        
        //Printing the passcode
        callPasscode(color1, color2, color3, color4);
          
        //Preparing to print a new line (if it's the last line this will start back up at the top)
        if (line == 760){
            line = 40;
            //Clearing the next line in the panel
            gfx.setColor(background);
            gfx.fillRect(200, line, 750, 70);
            nowErasing = true;
        }
        else if (nowErasing == true){    
            line = line + radius + 30;
            //Clearing the next line in the panel
            gfx.setColor(background);
            gfx.fillRect(200, line, 750, 70);
        }
        else
            line = line + radius + 30;
        
        //Preparing to print a new line
        guessNumber = 0;
        length = 300;
    }//GEN-LAST:event_btnGiveUpActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (length > 300){ 
            
            length = length - 150;
            gfx.setColor(background);
            gfx.fillOval(length, line, radius, radius);
            
            //Wipes the previous guess
            switch (length)
                {
                    case 300:
                        guess1 = "";
                        break;
                    case 450:
                        guess2 = "";
                        break;
                    case 600: 
                        guess3 = "";
                        break;
                    case 750: 
                        guess4 = "";
                        break;
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        if (single == true){
            //Re-initializing the passcode
            color1 = colorArray[(int) Math.ceil(Math.random() * 8) - 1];
            color2 = colorArray[(int) Math.ceil(Math.random() * 8) - 1];
            color3 = colorArray[(int) Math.ceil(Math.random() * 8) - 1];
            color4 = colorArray[(int) Math.ceil(Math.random() * 8) - 1];
            
            //re-initializing line
            line = 40;
            
            System.out.println(color1 + " " + color2 + " " + color3 + " " + color4);
        }
        else{
            //making correct components appear
            btnGiveUp.setVisible(false);
            btnReset.setVisible(false);
            btnGuess.setVisible(false);
            btnSubmit.setVisible(true);
            lblInstructions.setVisible(true);
            
            //re-initializing line
            line = 140;
        }

        //re-initializing other variables that help with guessing process
        guessNumber = 0;
        length = 300;
        radius = 50;

        //re-initializing number of right colours and right spots
        rightColors = 0;
        rightSpots = 0;

        //re-initializing timer variables
        millis = 0;
        secs = 0;
        mins = 0;
        
        //Stop timer if it's running
        try {
            timer.stop();
            timer2.stop();
        } catch (Exception e){
        }

        //Decide whether or not to start timer
        settings = cmbSettings.getSelectedItem();//determine if user has selected timed or not
        lblTimer.setText("00:00:00");
        if (settings.equals("Timed")){   
            lblTimer.setForeground(Color.WHITE);
            if (single == true){
                timer.start();
            }
        }
        
        //Clearing the entire panel
        gfx.setColor(background);
        gfx.fillRect(200, 0, 800, 1000);
        gfx.fillRect(1000, 100, 300, 500);
        gfx.drawString("Time's Up!!", 1000, 300);
    }//GEN-LAST:event_btnResetActionPerformed

    private void cmbSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSettingsActionPerformed
        //Doesn't do anything
    }//GEN-LAST:event_cmbSettingsActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        settings = cmbSettings.getSelectedItem();//determine if user has selected timed or not
        if (settings.equals("Timed"))
            timer.start();
        else{
            try{
                timer.stop();
                timer2.stop();
            } catch (Exception eError){
            }
            lblTimer.setText("00:00:00");
        }
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        try{
            if (!guess4.equals("")){
                //Getting the passcode
                color1 = guess1;
                color2 = guess2;
                color3 = guess3;
                color4 = guess4;
                System.out.println(color1 + " " + color2 + " " + color3 + " " + color4);

                //Clearing the entire panel
                gfx.setColor(background);
                gfx.fillRect(200, 0, 800, 1000);

                //Resettting variables
                guessNumber = 0;
                length = 300;
                line = 40;

                //Showing The Correct Components
                btnGiveUp.setVisible(true);
                btnReset.setVisible(true);
                btnGuess.setVisible(true);
                btnSubmit.setVisible(false);
                lblInstructions.setVisible(false);

                //Resetting the guesses
                guess1 = "";
                guess2 = "";
                guess3 = "";
                guess4 = "";

                timer.start();
            }             
        } catch (Exception e){
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    //Computer generated main method, this is essentially unused
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //Allows this window to be opened
                new MastermindMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBlue;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGiveUp;
    private javax.swing.JButton btnGreen;
    private javax.swing.JButton btnGuess;
    private javax.swing.JButton btnMagenta;
    private javax.swing.JButton btnOrange;
    private javax.swing.JButton btnPink;
    private javax.swing.JButton btnRed;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnWhite;
    private javax.swing.JButton btnYellow;
    private javax.swing.JComboBox<String> cmbSettings;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JLabel lblQuestions;
    private javax.swing.JLabel lblQuestions2;
    private javax.swing.JLabel lblQuestions3;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel pnlWindows;
    // End of variables declaration//GEN-END:variables
}