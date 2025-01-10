import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    static Card.MColor YELLOW = Card.MColor.YELLOW;
    static Card.MColor BLUE = Card.MColor.BLUE;
    static Card.MColor ORANGE = Card.MColor.ORANGE;
    static Card.MColor PURPLE = Card.MColor.PURPLE;
    public static int x1, y1, x2, y2, x3, y3, x4, y4, x, y, m1, m2, m3, m4, e1, e, u;
    public static int[] xDotArray = {502,625,690,646,536,415,323,294,340,444,579,707,804,845,823,740,617,472,332,219};
    public static int[] yDotArray = {580,573,449,326,262,279,374,506,636,724,750,705,598,458,310,188,113,94,138,237};
    
    public static BufferedImage imgc1 = null;
    public static BufferedImage imgc2 = null;
    public static BufferedImage imgc3 = null;
    public static BufferedImage imgc4 = null;
    public static BufferedImage imgc5 = null;
    public static BufferedImage imgc6 = null;

    public static Image dimgc1 = null;
    public static Image dimgc2 = null;
    public static Image dimgc3 = null;
    public static Image dimgc4 = null;
    public static Image dimgc5 = null;
    public static Image dimgc6 = null;

    public static BufferedImage imge1 = null;
    public static BufferedImage imge2 = null;
    public static BufferedImage imge3 = null;
    public static BufferedImage imge4 = null;

    public static Image dimge1 = null;
    public static Image dimge2 = null;
    public static Image dimge3 = null;
    public static Image dimge4 = null;

    public static BufferedImage imgplus = null;
    public static BufferedImage imgsub = null;
    public static Image dimgplus = null;    
    public static Image dimgsub = null;

    public static BufferedImage pick = null;
    public static BufferedImage put = null;
    public static Image dimgpick = null;
    public static Image dimgput = null;

	private static void playBackgroundMusic(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private static void playWinMusic(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private static void playLoseMusic(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //Subjects' panels
    public static JPanel mpanel1 = new JPanel();
    static {
        mpanel1.setOpaque(false);
        mpanel1.setBounds(50, 50, 60, 60);
        mpanel1.setLayout(null);
    }
    public static JPanel mpanel2 = new JPanel();
    static {
        mpanel2.setOpaque(false);
        mpanel2.setBounds(50, 120, 60, 60);
        mpanel2.setLayout(null);
    }
    public static JPanel mpanel3 = new JPanel();
    static {
        mpanel3.setOpaque(false);
        mpanel3.setBounds(50, 190, 60, 60);
        mpanel3.setLayout(null);
    }
    public static JPanel mpanel4 = new JPanel();
    static {
        mpanel4.setOpaque(false);
        mpanel4.setBounds(50, 260, 60, 60);
        mpanel4.setLayout(null);
    }

    public static JPanel ePanel = new JPanel();
    static {
        ePanel.setOpaque(false);
        ePanel.setBounds(515, 425, 60, 60);
        ePanel.setLayout(null);
    }

    public static JPanel losePanel = new JPanel();
    static {
        losePanel.setBackground(Color.decode("#000000"));
    }
    public static JPanel winPanel = new JPanel();
    static {
        winPanel.setBackground(Color.decode("#FFFFFF"));
        winPanel.setLayout(null);
    }
    public static JPanel danPanel = new JPanel();
    static {
        danPanel.setOpaque(false);
        danPanel.setLayout(null);
    }
    public static JPanel aPanel = new JPanel();
    static {
        aPanel.setOpaque(false);
        aPanel.setBounds(990, 405, 80, 80);
        aPanel.setLayout(null);
    }

    public static JButton restaButton = new JButton("Try again");
    static {
        restaButton.setBounds(418, 682, 250, 50);
    }

    public static JLabel loseLabel = new JLabel();
    static {
        loseLabel.setForeground(Color.decode("#FF0000"));
        loseLabel.setBounds(100, 182, 1000, 500);
        losePanel.add(loseLabel);
        losePanel.setLayout(null);
        losePanel.add(restaButton);
    }

    public static void Win() {
        winPanel.setBounds(0, 0, 1080, 1080);

        JLabel winLabel = new JLabel();
        winLabel.setForeground(Color.decode("#00FF00"));
        winLabel.setBounds(100, 182, 1080, 500);
        winPanel.add(winLabel);
        winLabel.setLayout(null);
        winPanel.add(restaButton);
        System.out.println("Congratulation! You win");
        playWinMusic("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\win.wav");
    }

    // calculate vector and check if it is out of bound
    public static boolean vectorCheck(int position[] ) {
        double xcenter = 542.5;
        double ycenter = 452.5;
        double[] xvector = {0,0,0,0,0};
        double[] yvector = {0,0,0,0,0};
        int n = 0;
        for (int i = 0; i < 20; i++) {
            if (position[i] == 1) {
                xvector[n] = xDotArray[i] + 33/2 - xcenter;
                yvector[n] = yDotArray[i] + 33/2 - ycenter;
                n++;
            }
        } 
        double xPlusVector = xvector[0] + xvector[1] + xvector[2] + xvector[3] + xvector[4];
        double yPlusVector = yvector[0] + yvector[1] + yvector[2] + yvector[3] + yvector[4];
        
        double xFinalVector = xcenter + xPlusVector;
        double yFinalVector = ycenter + yPlusVector;
        
        double danX = xPlusVector*1.2 + xcenter;
        double danY = yPlusVector*1.2 + ycenter;

        danPanel.setBounds((int)danX - 25, (int)danY - 25, 50, 50);

        System.out.println(xFinalVector + " " + yFinalVector);
        if (xFinalVector > 880 || xFinalVector < 200 || yFinalVector > 785 || yFinalVector < 75) {
            System.out.println("Fail");
            return false;
        } 
        return true;
    }

    //create deck
    public static Deck deck = new Deck();
    static {
        deck.reset();
    }

    public static Card card1 = deck.dealCard();
    public static Card card2 = deck.dealCard();
    public static Card card3 = deck.dealCard();
    public static Card card4 = deck.dealCard();
    public static Card card5 = deck.dealCard();
    public static Card card6 = deck.dealCard();

    public static void main(String[] args) {
        //==============================================================================================================
        // Create fields' panels
        JPanel purPanel = new JPanel();
        purPanel.setBackground(Color.decode("#800080"));
        purPanel.setBounds(1080, 0, 456, 170);
        purPanel.setLayout(null);

        JPanel bluepanel = new JPanel();
        bluepanel.setBackground(Color.decode("#0000FF"));
        bluepanel.setBounds(1080, 170, 456, 170);
        bluepanel.setLayout(null);

        JPanel redpanel = new JPanel();
        redpanel.setBackground(Color.decode("#FF0000"));
        redpanel.setBounds(1080, 340, 456, 170);
        redpanel.setLayout(null);

        JPanel yellowpanel = new JPanel();
        yellowpanel.setBackground(Color.decode("#FFFF00"));
        yellowpanel.setBounds(1080, 510, 456, 170);
        yellowpanel.setLayout(null);

        JPanel orangepanel = new JPanel();
        orangepanel.setBackground(Color.decode("#FFA500"));
        orangepanel.setBounds(1080, 680, 456, 184);
        orangepanel.setLayout(null);

        JPanel treepanel = new JPanel();
        treepanel.setBackground(Color.decode("#FFFFF0"));
        treepanel.setBounds(0, 0, 1080, 1080);
        treepanel.setLayout(null);

        //add & resize image of jungle
        BufferedImage imgjung = null;
        try {
            imgjung = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\jungle2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgjung = imgjung.getScaledInstance(1080, 1080,Image.SCALE_SMOOTH);
        ImageIcon imageIconjung = new ImageIcon(dimgjung);
        JLabel jung = new JLabel(imageIconjung);
        jung.setBounds(0,0, 1080, 1080);
        treepanel.add(jung);
        
        //==============================================================================================================
        //add & resize image of tree
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\simple_tree.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(1250, 980,Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        JLabel tree = new JLabel(imageIcon);
        tree.setBounds(-100, -50, 1250, 980);
        
        //add & resize subjects' images
        BufferedImage imgm1 = null; //Yellow monkey
        try {
            imgm1 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\monkeyface1.png"));
        } catch (IOException e) {                  
            e.printStackTrace();
        }
        Image dimgm1 = imgm1.getScaledInstance(60, 60,Image.SCALE_SMOOTH);
        ImageIcon imageIconm1 = new ImageIcon(dimgm1);  
        JLabel mon1 = new JLabel(imageIconm1);
        mon1.setBounds(0, 0, 60, 60);
        mpanel1.add(mon1);

        BufferedImage imgm2 = null; //Blue monkey
        try {
            imgm2 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\monkeyface2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgm2 = imgm2.getScaledInstance(60, 60,Image.SCALE_SMOOTH);
        ImageIcon imageIconm2 = new ImageIcon(dimgm2);  
        JLabel mon2 = new JLabel(imageIconm2);
        mon2.setBounds(0, 0, 60, 60);
        mpanel2.add(mon2);
        
        BufferedImage imgm3 = null; //Orange monkey
        try {
            imgm3 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\monkeyface3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgm3 = imgm3.getScaledInstance(60, 60,Image.SCALE_SMOOTH);
        ImageIcon imageIconm3 = new ImageIcon(dimgm3);  
        JLabel mon3 = new JLabel(imageIconm3);
        mon3.setBounds(0, 0, 60, 60);
        mpanel3.add(mon3);

        BufferedImage imgm4 = null; //Purple monkey
        try {
            imgm4 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\monkeyface4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgm4 = imgm4.getScaledInstance(60, 60,Image.SCALE_SMOOTH);
        ImageIcon imageIconm4 = new ImageIcon(dimgm4);  
        JLabel mon4 = new JLabel(imageIconm4);
        mon4.setBounds(0, 0, 60, 60);
        mpanel4.add(mon4);

        BufferedImage imge = null; //Elephant
        try {
            imge = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\elephant.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimge = imge.getScaledInstance(60, 60,Image.SCALE_SMOOTH);
        ImageIcon imageIcone = new ImageIcon(dimge);  
        JLabel ele = new JLabel(imageIcone);
        ele.setBounds(0, 0, 60, 60);
        ePanel.add(ele);

        BufferedImage imgdan = null; //Danger sign
        try {
            imgdan = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\heavy.png"));
        } catch (IOException e) {                  
            e.printStackTrace();
        }
        Image dimgdan = imgdan.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
        ImageIcon imageIcondan = new ImageIcon(dimgdan);  
        JLabel dan = new JLabel(imageIcondan);
        dan.setBounds(0, 0, 50, 50);
        danPanel.add(dan);

        //Arrow
        ImageIcon imageIconarr = new ImageIcon("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\star_blink.gif");
        JLabel arr = new JLabel(imageIconarr);
        arr.setBounds(0, 0, 80, 80);
        aPanel.add(arr);

        //You lose
        ImageIcon imageIconlose = new ImageIcon("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\lose.gif");  
        JLabel lose = new JLabel(imageIconlose);
        lose.setBounds(0, 0, 1080, 864);
        losePanel.add(lose);

        //You win
        ImageIcon imageIconwin = new ImageIcon("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\win.gif");  
        JLabel win = new JLabel(imageIconwin);
        win.setBounds(0, 0, 1080, 864);
        winPanel.add(win); 
   

        // array of the positions of the subjects
        int[] position = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        
        // create elephant's buttons, add images to buttons and set their actions
        try {
            imge1 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\el1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimge1 = imge1.getScaledInstance(280, 180,Image.SCALE_SMOOTH);

        try {
            imge3 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\el3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimge3 = imge3.getScaledInstance(295, 160,Image.SCALE_SMOOTH);

        JButton eButton1 = new JButton();
        eButton1.setIcon(new ImageIcon(dimge1));
        eButton1.setMargin(new Insets(20,0,0,10));
        eButton1.addActionListener(ev1 -> {
            JButton eButton3 = new JButton("e-3");
            eButton3.setIcon(new ImageIcon(dimge3));
            eButton3.setMargin(new Insets(20,10,0,0));
            eButton3.addActionListener(ev3 -> {
                e1 = 3;
                purPanel.remove(eButton3);
                purPanel.add(eButton1);
            });
            eButton3.setBounds(10, 10, 213, 90);
            purPanel.add(eButton3);

            e1 = 1;
            System.out.println("eButton1 pressed");
            purPanel.remove(eButton1);
        });

        try {
            imge2 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\el2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimge2 = imge2.getScaledInstance(300, 150,Image.SCALE_SMOOTH);

        try {
            imge4 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\el4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimge4 = imge4.getScaledInstance(265, 150,Image.SCALE_SMOOTH);

        JButton eButton2 = new JButton();
        eButton2.setIcon(new ImageIcon(dimge2));
        eButton2.setMargin(new Insets(0,0,0,7));
        eButton2.addActionListener(ev2 -> {
            JButton eButton4 = new JButton();
            eButton4.setIcon(new ImageIcon(dimge4));
            eButton4.setMargin(new Insets(13,0,0,7));
            eButton4.addActionListener(ev4 -> {
                e1 = 4;
                purPanel.remove(eButton4);
                purPanel.add(eButton2);
            });
            eButton4.setBounds(233, 10, 213, 90);
            purPanel.add(eButton4);

            e1 = 2;
            System.out.println("eButton2 pressed");
            purPanel.remove(eButton2);
        });
        
        //pick up and put down buttons for elephants, add images to buttons and set their actions
        try {
            pick = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\Pick_up.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimgpick = pick.getScaledInstance(128, 58,Image.SCALE_SMOOTH);

        try {
            put= ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\Put_down.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimgput = put.getScaledInstance(128, 58,Image.SCALE_SMOOTH);

        JButton ePickButton = new JButton();
        ePickButton.setIcon(new ImageIcon(dimgpick));
        ePickButton.setMargin(new Insets(10,0,0,0));
        ePickButton.addActionListener(ev -> {

            JButton ePutButton = new JButton();
            ePutButton.setIcon(new ImageIcon(dimgput));
            ePutButton.setMargin(new Insets(0,0,10,0));
            ePutButton.addActionListener(ev1 -> {
                e += e1;
                if (e > 20) {
                    Win();
                } else {
                    if (position[e-1] == 1){
                        e -= e1;
                        return;
                    }
                    position[e-1] = 1;
                    boolean checklose = vectorCheck(position); // check if the vector is out of bound after put down
                    if (checklose == false) { // if it is out of bound, then you lose
                        losePanel.setLayout(null);
                        losePanel.setBounds(0, 0, 1080, 1080);
                        playLoseMusic("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\lose.wav");
                        System.out.println("You lose");
                    }
                    ePanel.setBounds(xDotArray[e-1]-13, yDotArray[e-1]-13, 60, 60);
                    e1 = 0;
                }
                purPanel.remove(ePutButton);
                System.out.println("ePutButton pressed");
                System.out.println("e = " + e);
                //print position
                for (int i = 0; i < 20; i++) {
                    System.out.print(position[i] + " ");
                }
            });
            purPanel.add(ePutButton);
            ePutButton.setBounds(153, 110, 150, 50);

            if(e != 0){ // clear the previous position of elephant
                position[e-1] = 0;
            }
            boolean checklose = vectorCheck(position); // check if the vector is out of bound after clear the previous position
            if (checklose == false) { // if it is out of bound, then you lose
                losePanel.setLayout(null);
                losePanel.setBounds(0, 0, 1080, 1080);
                System.out.println("You lose");
            }

            ePanel.setBounds(50, 330, 60, 60);
            System.out.println("ePickButton pressed");
            purPanel.remove(ePickButton);
        });
        purPanel.add(eButton1); purPanel.add(eButton2);
        eButton1.setBounds(10, 10, 213, 90);
        eButton2.setBounds(233, 10, 213, 90);
        ePickButton.setBounds(153, 110, 150, 50);

        //card buttons of p1 and set their actions
        try {
            imgc1 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card1.toString()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimgc1 = imgc1.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
        
        JButton button1 = new JButton();
        button1.setIcon(new ImageIcon(dimgc1));
        button1.setMargin(new Insets(0, 10, 0, 0));
        button1.setText(card1.toString());
        button1.addActionListener(e -> {
            if (x1 == 0 && x4 == 0) {
                x1 = card1.getValue();
                if(card1.getColor() == YELLOW) {
                    y1 = 1;
                } else if(card1.getColor() == BLUE) {
                    y1 = 2;
                } else if(card1.getColor() == ORANGE) {
                    y1 = 3;
                } else if(card1.getColor() == PURPLE) {
                    y1 = 4;
                }
            } else if (x1 != 0 && x3 == 0){
                x2 = card1.getValue();
                if(card1.getColor() == YELLOW) {
                    y2 = 1;
                } else if(card1.getColor() == BLUE) {
                    y2 = 2;
                } else if(card1.getColor() == ORANGE) {
                    y2 = 3;
                } else if(card1.getColor() == PURPLE) {
                    y2 = 4;
                }
            }
            System.out.println("Button 1 pressed");
            System.out.println("x1 = " + x1 + " x2 = " + x2 + " x3 = " + x3 + " x4 = " + x4);
        });
        button1.setBounds(10, 10, 120, 150);
        
        try {
            imgc2 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card2.toString()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimgc2 = imgc2.getScaledInstance(135, 160,Image.SCALE_SMOOTH);

        JButton button2 = new JButton();
        button2.setIcon(new ImageIcon(dimgc2));
        button2.setMargin(new Insets(0, 10, 0, 0));
        button2.setText(card2.toString());
        button2.addActionListener(e -> {
            if (x1 == 0 && x4 == 0) {
                x1 = card2.getValue();
                if(card2.getColor() == YELLOW) {
                    y1 = 1;
                } else if(card2.getColor() == BLUE) {
                    y1 = 2;
                } else if(card2.getColor() == ORANGE) {
                    y1 = 3;
                } else if(card2.getColor() == PURPLE) {
                    y1 = 4;
                }
            } else if (x1 != 0 && x3 == 0){
                x2 = card2.getValue();
                if(card2.getColor() == YELLOW) {
                    y2 = 1;
                } else if(card2.getColor() == BLUE) {
                    y2 = 2;
                } else if(card2.getColor() == ORANGE) {
                    y2 = 3;
                } else if(card2.getColor() == PURPLE) {
                    y2 = 4;
                }
            }
            System.out.println("Button 2 pressed");
            System.out.println("x1 = " + x1 + " x2 = " + x2 + " x3 = " + x3 + " x4 = " + x4);
        });
        button2.setBounds(150, 10, 120, 150);
        
        try {
            imgc3 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card3.toString()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimgc3 = imgc3.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
        
        JButton button3 = new JButton();
        button3.setIcon(new ImageIcon(dimgc3));
        button3.setMargin(new Insets(0, 10, 0, 0));
        button3.setText(card3.toString());
        button3.addActionListener(e -> {
            if (x1 == 0 && x4 == 0) {
                x1 = card3.getValue();
                if(card3.getColor() == YELLOW) {
                    y1 = 1;
                } else if(card3.getColor() == BLUE) {
                    y1 = 2;
                } else if(card3.getColor() == ORANGE) {
                    y1 = 3;
                } else if(card3.getColor() == PURPLE) {
                    y1 = 4;
                }
            } else if (x1 != 0 && x3 == 0){
                x2 = card3.getValue();
                if(card3.getColor() == YELLOW) {
                    y2 = 1;
                } else if(card3.getColor() == BLUE) {
                    y2 = 2;
                } else if(card3.getColor() == ORANGE) {
                    y2 = 3;
                } else if(card3.getColor() == PURPLE) {
                    y2 = 4;
                }
            }
            System.out.println("Button 3 pressed");
            System.out.println("x1 = " + x1 + " x2 = " + x2 + " x3 = " + x3 + " x4 = " + x4);
        });
        button3.setBounds(290, 10, 120, 150);
        redpanel.add(button1);
        redpanel.add(button2);
        redpanel.add(button3);

        //card button of p2 and set their actions
        try {
            imgc4 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card4.toString()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimgc4 = imgc4.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
        
        JButton button4 = new JButton();
        button4.setIcon(new ImageIcon(dimgc4));
        button4.setMargin(new Insets(0, 10, 0, 0));
        button4.setText(card4.toString());
        button4.addActionListener(e -> {
            if (x3 == 0 && x2 == 0){
                x3 = card4.getValue();
                if(card4.getColor() == YELLOW) {
                    y3 = 1;
                } else if(card4.getColor() == BLUE) {
                    y3 = 2;
                } else if(card4.getColor() == ORANGE) {
                    y3 = 3;
                } else if(card4.getColor() == PURPLE) {
                    y3 = 4;
                }
            } else if (x3 != 0 && x1 == 0){
                x4 = card4.getValue();
                if(card4.getColor() == YELLOW) {
                    y4 = 1;
                } else if(card4.getColor() == BLUE) {
                    y4 = 2;
                } else if(card4.getColor() == ORANGE) {
                    y4 = 3;
                } else if(card4.getColor() == PURPLE) {
                    y4 = 4;
                }
            }
            System.out.println("Button 4 pressed");
            System.out.println("x1 = " + x1 + " x2 = " + x2 + " x3 = " + x3 + " x4 = " + x4);
        });
        button4.setBounds(10, 10, 120, 150);

        try {
            imgc5 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card5.toString()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimgc5 = imgc5.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
        
        JButton button5 = new JButton();
        button5.setIcon(new ImageIcon(dimgc5));
        button5.setMargin(new Insets(0, 10, 0, 0));
        button5.setText(card5.toString());
        button5.addActionListener(e -> {
            if (x3 == 0 && x2 == 0){
                x3 = card5.getValue();
                if(card5.getColor() == YELLOW) {
                    y3 = 1;
                } else if(card5.getColor() == BLUE) {
                    y3 = 2;
                } else if(card5.getColor() == ORANGE) {
                    y3 = 3;
                } else if(card5.getColor() == PURPLE) {
                    y3 = 4;
                }
            } else if (x3 != 0 && x1 == 0){
                x4 = card5.getValue();
                if(card5.getColor() == YELLOW) {
                    y4 = 1;
                } else if(card5.getColor() == BLUE) {
                    y4 = 2;
                } else if(card5.getColor() == ORANGE) {
                    y4 = 3;
                } else if(card5.getColor() == PURPLE) {
                    y4 = 4;
                }
            }
            System.out.println("Button 5 pressed");
            System.out.println("x1 = " + x1 + " x2 = " + x2 + " x3 = " + x3 + " x4 = " + x4);
        });
        button5.setBounds(150, 10, 120, 150);

        try {
            imgc6 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card6.toString()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimgc6 = imgc6.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
        
        JButton button6 = new JButton();
        button6.setIcon(new ImageIcon(dimgc6));
        button6.setMargin(new Insets(0, 10, 0, 0));
        button6.setText(card6.toString());
        button6.addActionListener(e -> {
            if (x3 == 0 && x2 == 0){
                x3 = card6.getValue();
                if(card6.getColor() == YELLOW) {
                    y3 = 1;
                } else if(card6.getColor() == BLUE) {
                    y3 = 2;
                } else if(card6.getColor() == ORANGE) {
                    y3 = 3;
                } else if(card6.getColor() == PURPLE) {
                    y3 = 4;
                }
            } else if (x3 != 0 && x1 == 0){
                x4 = card6.getValue();
                if(card6.getColor() == YELLOW) {
                    y4 = 1;
                } else if(card6.getColor() == BLUE) {
                    y4 = 2;
                } else if(card6.getColor() == ORANGE) {
                    y4 = 3;
                } else if(card6.getColor() == PURPLE) {
                    y4 = 4;
                }
            }
            System.out.println("Button 6 pressed");
            System.out.println("x1 = " + x1 + " x2 = " + x2 + " x3 = " + x3 + " x4 = " + x4);
        });
        button6.setBounds(290, 10, 120, 150);
        yellowpanel.add(button4);
        yellowpanel.add(button5);
        yellowpanel.add(button6);

        // sub and add button
        try {
            imgsub = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\subtract.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimgsub = imgsub.getScaledInstance(128, 58,Image.SCALE_SMOOTH);

        JButton subbutton = new JButton();
        subbutton.setIcon(new ImageIcon(dimgsub));
        subbutton.addActionListener(e -> {
            if(x1 > x2 && y1 == y2) {
                x = x1 - x2;
            } else if(x1 < x2 && y1 == y2) {
                x = x2 - x1;
            } else if (x3 > x4 && y3 == y4) {
                x = x3 - x4;
            } else if (x3 < x4 && y3 == y4) {
                x = x4 - x3;
            } else if(x1 > x3 && y1 == y3){
                x = x1 - x3;
            } else if(x3 > x1 && y1 == y3){
                x = x3 - x1;
            }
            System.out.println("Subbutton pressed");
            System.out.println("x = " + x);
        });

        try {
            imgplus = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\plus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dimgplus = imgplus.getScaledInstance(128, 58,Image.SCALE_SMOOTH);

        JButton addbutton = new JButton();
        addbutton.setIcon(new ImageIcon(dimgplus));
        addbutton.addActionListener(e -> {
            if (y1 == y2 && y1 != 0){
                x = x1 + x2;
            } else if (y3 == y4 && y3 != 0){
                x = x3 + x4;
            } else if (y1 == y3){
                x = x1 + x3;
            }
            System.out.println("Addbutton pressed");
            System.out.println("x = " + x);
        });

        //clear button 
        JButton clearbutton = new JButton("Clear");
        clearbutton.addActionListener(e -> {
            x1 = 0;
            y1 = 0;
            x2 = 0;
            y2 = 0;
            x3 = 0;
            y3 = 0;
            x4 = 0;
            y4 = 0;
            x = 0;
            y = 0;
            System.out.println("Clearbutton pressed");
            //print position
            for (int i = 0; i < 20; i++) {
                System.out.print(position[i] + " ");
            }
        });
        clearbutton.setBounds(163, 10, 130, 60);
        orangepanel.add(clearbutton);

        //==============================================================================================================
        // pick up and put down button for monkeys
        JButton pickbutton = new JButton();
        pickbutton.setIcon(new ImageIcon(dimgpick));
        pickbutton.setMargin(new Insets(10,0,0,0));
        pickbutton.addActionListener(e -> {
            // put down button
            JButton putbutton = new JButton();
            putbutton.setIcon(new ImageIcon(dimgput));
            putbutton.setMargin(new Insets(0,0,10,0));
            putbutton.addActionListener(e1 -> {
                if (x1 == 0 && u == 1 && x4 == 0) {  
                    x = x3;
                } else if (x3 == 0 && u == 0 && x2 == 0) { 
                    x = x1;
                } else if (x1 == 0 && u == 0 || x3 == 0 && u == 1) {
                    x = 0;
                }
                System.out.println("x = " + x);
                if(y1 == 1 || y2 == 1 || y3 == 1 || y4 == 1) {
                    m1 = x;
                    if (position[m1-1] == 1){
                        return;
                    }
                    position[m1-1] = 1;
                } else if(y1 == 2 || y2 == 2 || y3 == 2 || y4 == 2) {
                    m2 = x; 
                    if (position[m2-1] == 1){
                        return;
                    }
                    position[m2-1] = 1;
                } else if(y1 == 3 || y2 == 3 || y3 == 3 || y4 == 3) {
                    m3 = x; 
                    if (position[m3-1] == 1){
                        return;
                    }
                    position[m3-1] = 1;
                } else if(y1 == 4 || y2 == 4 || y3 == 4 || y4 == 4) {
                    m4 = x; 
                    if (position[m4-1] == 1){
                        return;
                    }
                    position[m4-1] = 1;
                }
                boolean checklose = vectorCheck(position); // check if the vector is out of bound after put down
                if (checklose == false) { //    if it is out of bound, then you lose
                    losePanel.setBounds(0, 0, 1080, 1080);
                    losePanel.setLayout(null);
                    System.out.println("You lose");
                }
                if(y1 == 1 || y2 == 1 || y3 == 1 || y4 == 1) {
                    mpanel1.setBounds(xDotArray[x-1]-13, yDotArray[x-1]-13, 60, 60);
                } else if(y1 == 2 || y2 == 2 || y3 == 2 || y4 == 2) {
                    mpanel2.setBounds(xDotArray[x-1]-13, yDotArray[x-1]-13 , 60, 60);
                } else if(y1 == 3 || y2 == 3 || y3 == 3 || y4 == 3) {
                    mpanel3.setBounds(xDotArray[x-1]-13, yDotArray[x-1]-13, 60, 60);
                } else if(y1 == 4 || y2 == 4 || y3 == 4 || y4 == 4) {
                    mpanel4.setBounds(xDotArray[x-1]-13, yDotArray[x-1]-13, 60, 60);
                }
                if(u == 0) {
                    if (card1.getValue() == x1){
                        card1 = deck.dealCard();
                        try {
                            imgc1 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card1.toString()+".png"));
                        } catch (IOException ev1) {
                            ev1.printStackTrace();
                        }
                        dimgc1 = imgc1.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button1.setIcon(new ImageIcon(dimgc1));
                        button1.setText(card1.toString());
                        u++;
                    } else if (card2.getValue() == x1){
                        card2 = deck.dealCard();
                        try {
                            imgc2 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card2.toString()+".png"));
                        } catch (IOException ev2) {
                            ev2.printStackTrace();
                        }
                        dimgc2 = imgc2.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button2.setIcon(new ImageIcon(dimgc2));
                        button2.setText(card2.toString());
                        u++;
                    } else if (card3.getValue() == x1){
                        card3 = deck.dealCard();
                        try {
                            imgc3 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card3.toString()+".png"));
                        } catch (IOException ev3) {
                            ev3.printStackTrace();
                        }
                        dimgc3 = imgc3.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button3.setIcon(new ImageIcon(dimgc3));
                        button3.setText(card3.toString());
                        u++;
                    }
                } else if(u == 1) {
                    if (card4.getValue() == x3){
                        card4 = deck.dealCard();
                        try {
                            imgc4 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card4.toString()+".png"));
                        } catch (IOException ev4) {
                            ev4.printStackTrace();
                        }
                        dimgc4 = imgc4.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button4.setIcon(new ImageIcon(dimgc4));
                        button4.setText(card4.toString());
                        u--;
                    } else if (card5.getValue() == x3){
                        card5 = deck.dealCard();
                        try {
                            imgc5 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card5.toString()+".png"));
                        } catch (IOException ev5) {
                            ev5.printStackTrace();
                        }
                        dimgc5 = imgc5.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button5.setIcon(new ImageIcon(dimgc5));
                        button5.setText(card5.toString());
                        u--;
                    } else if (card6.getValue() == x3){
                        card6 = deck.dealCard();
                        try {
                            imgc6 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card6.toString()+".png"));
                        } catch (IOException ev6) {
                            ev6.printStackTrace();
                        }
                        dimgc6 = imgc6.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button6.setIcon(new ImageIcon(dimgc6));
                        button6.setText(card6.toString());
                        u--;
                    }
                }
                deck.shuffleDeck();
                if (deck.isDeckEmpty()) {
                    deck.reset();
                }
                x1 = 0;
                y1 = 0;
                x2 = 0;
                y2 = 0;
                x3 = 0;
                y3 = 0;
                x4 = 0;
                y4 = 0;
                x = 0;
                y = 0;
                if (u == 0) {
                    aPanel.setBounds(990, 405, 80, 80);
                } else if (u == 1) {
                    aPanel.setBounds(990, 575, 80, 80);
                }
                System.out.println("Putbutton pressed");
                //print position on system
                for (int i = 0; i < 20; i++) {
                    System.out.print(position[i] + " ");
                }
                System.out.println();
                orangepanel.remove(putbutton); // change putbutton to pickbutton
                orangepanel.add(pickbutton);
                purPanel.add(ePickButton);
            });
            orangepanel.add(putbutton);
            putbutton.setBounds(143, 120, 170, 60); // end of putbutton

            if(y1 == 1 || y2 == 1 || y3 == 1 || y4 == 1) {
                if(m1 != 0){
                    position[m1-1] = 0;
                }
            } else if(y1 == 2 || y2 == 2 || y3 == 2 || y4 == 2) {
                if(m2 != 0){
                    position[m2-1] = 0;
                }
            } else if(y1 == 3 || y2 == 3 || y3 == 3 || y4 == 3) {
                if(m3 != 0){
                    position[m3-1] = 0;
                }
            } else if(y1 == 4 || y2 == 4 || y3 == 4 || y4 == 4) {
                if(m4 != 0){
                    position[m4-1] = 0;
                }
            }
            
            boolean checklose = vectorCheck(position); // check if the vector is out of bound after clear the previous position
            if (checklose == false) { // if it is out of bound, then you lose
                losePanel.setBounds(0, 0, 1080, 1080);
                losePanel.setLayout(null);
                System.out.println("You lose");
            }
            if (y1 == 1 || y2 == 1 || y3 == 1 || y4 == 1) {
                mpanel1.setBounds(50, 50, 60, 60);
            } else if (y1 == 2 || y2 == 2 || y3 == 2 || y4 == 2) {
                mpanel2.setBounds(50, 120, 60, 60);
            } else if (y1 == 3 || y2 == 3 || y3 == 3 || y4 == 3) {
                mpanel3.setBounds(50, 190, 60, 60);
            } else if (y1 == 4 || y2 == 4 || y3 == 4 || y4 == 4) {
                mpanel4.setBounds(50, 260, 60, 60);
            }
            System.out.println("Pickbutton pressed");
            orangepanel.remove(pickbutton); // change pickbutton to putbutton
        });
         
        addbutton.setBounds(316, 10, 130, 60);
        subbutton.setBounds(10, 10, 130, 60);
        pickbutton.setBounds(143, 120, 170, 60);
        orangepanel.add(pickbutton);
        orangepanel.add(subbutton);
        orangepanel.add(addbutton);

        // jokers buttons and set their actions
        BufferedImage imgj1 = null; //change card joker
        try {
            imgj1 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\joker1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgj1 = imgj1.getScaledInstance(160, 160,Image.SCALE_SMOOTH);
        ImageIcon imageIconj1 = new ImageIcon(dimgj1);

        JButton fButton1 = new JButton(imageIconj1); 
        fButton1.setMargin(new Insets(18, 0, 0, 0));
        fButton1.addActionListener(e -> {
            if (u == 0){
                card1 = deck.dealCard();
                card2 = deck.dealCard();
                card3 = deck.dealCard();
                try {
                    imgc1 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card1.toString()+".png"));
                    imgc2 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card2.toString()+".png"));
                    imgc3 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card3.toString()+".png"));
                } catch (IOException ev1) {
                    ev1.printStackTrace();
                }
                dimgc1 = imgc1.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                dimgc2 = imgc2.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                dimgc3 = imgc3.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                button1.setIcon(new ImageIcon(dimgc1));
                button2.setIcon(new ImageIcon(dimgc2));
                button3.setIcon(new ImageIcon(dimgc3));
                button1.setText(card1.toString());
                button2.setText(card2.toString());
                button3.setText(card3.toString());
            } else if (u == 1){
                card4 = deck.dealCard();
                card5 = deck.dealCard();
                card6 = deck.dealCard();
                try {
                    imgc4 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card4.toString()+".png"));
                    imgc5 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card5.toString()+".png"));
                    imgc6 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card6.toString()+".png"));
                } catch (IOException ev1) {
                    ev1.printStackTrace();
                }
                dimgc4 = imgc4.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                dimgc5 = imgc5.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                dimgc6 = imgc6.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                button4.setIcon(new ImageIcon(dimgc4));
                button5.setIcon(new ImageIcon(dimgc5));
                button6.setIcon(new ImageIcon(dimgc6));
                button4.setText(card4.toString());
                button5.setText(card5.toString());
                button6.setText(card6.toString());
            }
            System.out.println("fButton1 pressed");
            bluepanel.remove(fButton1);
        });
        bluepanel.add(fButton1);
        fButton1.setBounds(10, 10, 120, 150);
        
        BufferedImage imgj2 = null;  //skip turn joker
        try {
            imgj2 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\joker2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgj2 = imgj2.getScaledInstance(183, 183,Image.SCALE_SMOOTH);
        ImageIcon imageIconj2 = new ImageIcon(dimgj2);

        JButton fButton2 = new JButton(imageIconj2);
        fButton2.setMargin(new Insets(0, 16, 9, 0));
        fButton2.addActionListener(e -> {
            if (u == 0){
                u++;
            } else if (u == 1){
                u--;
            }
            if (u == 0) {
                aPanel.setBounds(990, 405, 80, 80);
            } else if (u == 1) {
                aPanel.setBounds(990, 575, 80, 80);
            }
            System.out.println("fButton2 pressed");
            bluepanel.remove(fButton2);
        });
        bluepanel.add(fButton2);
        fButton2.setBounds(150, 10, 120, 150);
        
        //hold the leaf joker 
        BufferedImage imgj3 = null;
        try {
            imgj3 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\joker3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimgj3 = imgj3.getScaledInstance(135, 135,Image.SCALE_SMOOTH);
        ImageIcon imageIconj3 = new ImageIcon(dimgj3);

        JButton fButton3 = new JButton(imageIconj3); 
        fButton3.setMargin(new Insets(8, 2, 0, 0));
        fButton3.addActionListener(e -> { //run the process of checklose after putting a monkey down
            orangepanel.remove(pickbutton);
            JButton putbutton = new JButton("Put down");
            putbutton.addActionListener(e1 -> {
                if (x1 == 0 && u == 1 && x4 == 0) {  
                    x = x3;
                } else if (x3 == 0 && u == 0 && x2 == 0) { 
                    x = x1;
                } else if (x1 == 0 && u == 0 || x3 == 0 && u == 1) {
                    x = 0;
                }
                System.out.println("x = " + x);
                if(y1 == 1 || y2 == 1 || y3 == 1 || y4 == 1) {
                    m1 = x;
                    if (position[m1-1] == 1){
                        return;
                    }
                    position[m1-1] = 1;
                } else if(y1 == 2 || y2 == 2 || y3 == 2 || y4 == 2) {
                    m2 = x; 
                    if (position[m2-1] == 1){
                        return;
                    }
                    position[m2-1] = 1;
                } else if(y1 == 3 || y2 == 3 || y3 == 3 || y4 == 3) {
                    m3 = x; 
                    if (position[m3-1] == 1){
                        return;
                    }
                    position[m3-1] = 1;
                } else if(y1 == 4 || y2 == 4 || y3 == 4 || y4 == 4) {
                    m4 = x; 
                    if (position[m4-1] == 1){
                        return;
                    }
                    position[m4-1] = 1;
                }
                boolean checklose = vectorCheck(position); // check if the vector is out of bound after put down
                if (checklose == false) { // if it is out of bound, then you lose
                    losePanel.setBounds(0, 0, 1080, 1080);
                    losePanel.setLayout(null);
                    System.out.println("You lose");
                } 
                if(y1 == 1 || y2 == 1 || y3 == 1 || y4 == 1) {
                    mpanel1.setBounds(xDotArray[x-1]-13, yDotArray[x-1]-13, 60, 60);
                } else if(y1 == 2 || y2 == 2 || y3 == 2 || y4 == 2) {
                    mpanel2.setBounds(xDotArray[x-1]-13, yDotArray[x-1]-13 , 60, 60);
                } else if(y1 == 3 || y2 == 3 || y3 == 3 || y4 == 3) {
                    mpanel3.setBounds(xDotArray[x-1]-13, yDotArray[x-1]-13, 60, 60);
                } else if(y1 == 4 || y2 == 4 || y3 == 4 || y4 == 4) {
                    mpanel4.setBounds(xDotArray[x-1]-13, yDotArray[x-1]-13, 60, 60);
                }
                if(u == 0) {
                    if (card1.getValue() == x1){
                        card1 = deck.dealCard();
                        try {
                            imgc1 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card1.toString()+".png"));
                        } catch (IOException ev1) {
                            ev1.printStackTrace();
                        }
                        dimgc1 = imgc1.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button1.setIcon(new ImageIcon(dimgc1));
                        button1.setText(card1.toString());
                        u++;
                    } else if (card2.getValue() == x1){
                        card2 = deck.dealCard();
                        try {
                            imgc2 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card2.toString()+".png"));
                        } catch (IOException ev2) {
                            ev2.printStackTrace();
                        }
                        dimgc2 = imgc2.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button2.setIcon(new ImageIcon(dimgc2));
                        button2.setText(card2.toString());
                        u++;
                    } else if (card3.getValue() == x1){
                        card3 = deck.dealCard();
                        try {
                            imgc3 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card3.toString()+".png"));
                        } catch (IOException ev3) {
                            ev3.printStackTrace();
                        }
                        dimgc3 = imgc3.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button3.setIcon(new ImageIcon(dimgc3));
                        button3.setText(card3.toString());
                        u++;
                    }
                } else if(u == 1) {
                    if (card4.getValue() == x3){
                        card4 = deck.dealCard();
                        try {
                            imgc4 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card4.toString()+".png"));
                        } catch (IOException ev4) {
                            ev4.printStackTrace();
                        }
                        dimgc4 = imgc4.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button4.setIcon(new ImageIcon(dimgc4));
                        button4.setText(card4.toString());
                        u--;
                    } else if (card5.getValue() == x3){
                        card5 = deck.dealCard();
                        try {
                            imgc5 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card5.toString()+".png"));
                        } catch (IOException ev5) {
                            ev5.printStackTrace();
                        }
                        dimgc5 = imgc5.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button5.setIcon(new ImageIcon(dimgc5));
                        button5.setText(card5.toString());
                        u--;
                    } else if (card6.getValue() == x3){
                        card6 = deck.dealCard();
                        try {
                            imgc6 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card6.toString()+".png"));
                        } catch (IOException ev6) {
                            ev6.printStackTrace();
                        }
                        dimgc6 = imgc6.getScaledInstance(135, 160,Image.SCALE_SMOOTH);
                        button6.setIcon(new ImageIcon(dimgc6));
                        button6.setText(card6.toString());
                        u--;
                    }
                }
                deck.shuffleDeck();
                if (deck.isDeckEmpty()) {
                    deck.reset();
                }
                x1 = 0;
                y1 = 0;
                x2 = 0;
                y2 = 0;
                x3 = 0;
                y3 = 0;
                x4 = 0;
                y4 = 0;
                x = 0;
                y = 0;
                if (u == 0) {
                    aPanel.setBounds(990, 405, 80, 80);
                } else if (u == 1) {
                    aPanel.setBounds(990, 575, 80, 80);
                }
                System.out.println("Putbutton pressed");
                //print position
                for (int i = 0; i < 20; i++) {
                    System.out.print(position[i] + " ");
                }
                System.out.println();
                orangepanel.remove(putbutton); // change putbutton to pickbutton
                orangepanel.add(pickbutton);
                purPanel.add(ePickButton);
            });
            orangepanel.add(putbutton);
            putbutton.setBounds(143, 120, 170, 60); // end of putbutton
            orangepanel.add(putbutton);
            System.out.println("fButton3 pressed");
            bluepanel.remove(fButton3);
        });
        bluepanel.add(fButton3);
        fButton3.setBounds(290, 10, 120, 150);

        // restart button, set everything to the initial state
        restaButton.addActionListener(ev -> {
            losePanel.setBounds(-1080, -1080, 1080, 1080);
            winPanel.setBounds(-1080, -1080, 1080, 1080);
            danPanel.setBounds(-100, -100, 40, 40);
            x1 = 0;
            y1 = 0;
            x2 = 0;
            y2 = 0;
            x3 = 0;
            y3 = 0;
            x4 = 0;
            y4 = 0;
            x = 0;
            y = 0;
            e = 0;
            e1 = 0;
            m1 = 0; m2 = 0; m3 = 0; m4 = 0;
            u = 0;
            for (int i = 0; i < 20; i++) {
                position[i] = 0;
            }
            ePanel.setBounds(515, 425, 60, 60);
            mpanel1.setBounds(50, 50, 60, 60);
            mpanel2.setBounds(50, 120, 60, 60);
            mpanel3.setBounds(50, 190, 60, 60);
            mpanel4.setBounds(50, 260, 60, 60);
            aPanel.setBounds(990, 405, 80, 80);
            purPanel.add(ePickButton);
            purPanel.add(eButton1); purPanel.add(eButton2);
            eButton1.setBounds(10, 10, 213, 90);
            eButton2.setBounds(233, 10, 213, 90);
            purPanel.remove(ePickButton);
            deck.reset();
            deck.shuffleDeck();
            card1 = deck.dealCard();
            card2 = deck.dealCard();
            card3 = deck.dealCard();
            card4 = deck.dealCard();
            card5 = deck.dealCard();
            card6 = deck.dealCard();
            try{
                imgc1 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card1.toString()+".png"));
                imgc2 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card2.toString()+".png"));
                imgc3 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card3.toString()+".png"));
                imgc4 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card4.toString()+".png"));
                imgc5 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card5.toString()+".png"));
                imgc6 = ImageIO.read(new File("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\"+card6.toString()+".png"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            dimgc1 = imgc1.getScaledInstance(135, 160, Image.SCALE_SMOOTH);
            dimgc2 = imgc2.getScaledInstance(135, 160, Image.SCALE_SMOOTH);
            dimgc3 = imgc3.getScaledInstance(135, 160, Image.SCALE_SMOOTH);
            dimgc4 = imgc4.getScaledInstance(135, 160, Image.SCALE_SMOOTH);
            dimgc5 = imgc5.getScaledInstance(135, 160, Image.SCALE_SMOOTH);
            dimgc6 = imgc6.getScaledInstance(135, 160, Image.SCALE_SMOOTH);
            
            button1.setIcon(new ImageIcon(dimgc1));
            button2.setIcon(new ImageIcon(dimgc2));
            button3.setIcon(new ImageIcon(dimgc3));
            button4.setIcon(new ImageIcon(dimgc4));
            button5.setIcon(new ImageIcon(dimgc5));
            button6.setIcon(new ImageIcon(dimgc6));

            bluepanel.add(fButton1);
            bluepanel.add(fButton2);
            bluepanel.add(fButton3);
            System.out.println("Restart button pressed");
        });

        //==============================================================================================================
        // create center panel and dot panel of the tree
        JPanel centerpanel = new JPanel();
        centerpanel.setBackground(Color.decode("#00FF00"));
        centerpanel.setBounds(505, 415, 75, 75);
        centerpanel.setLayout(null);
        JPanel dotpanel1 = new JPanel();
        dotpanel1.setBackground(Color.decode("#00FF00"));
        dotpanel1.setBounds(502, 580, 33, 33);
        JPanel dotpanel2 = new JPanel();
        dotpanel2.setBackground(Color.decode("#00FF00"));
        dotpanel2.setBounds(625, 573, 33, 33);
        JPanel dotpanel3 = new JPanel();
        dotpanel3.setBackground(Color.decode("#00FF00"));
        dotpanel3.setBounds(690, 449, 33, 33);
        JPanel dotpanel4 = new JPanel();
        dotpanel4.setBackground(Color.decode("#00FF00"));
        dotpanel4.setBounds(646, 326, 33, 33);
        JPanel dotpanel5 = new JPanel();
        dotpanel5.setBackground(Color.decode("#00FF00"));
        dotpanel5.setBounds(536, 262, 33, 33);
        JPanel dotpanel6 = new JPanel();
        dotpanel6.setBackground(Color.decode("#00FF00"));
        dotpanel6.setBounds(415, 279, 33, 33);
        JPanel dotpanel7 = new JPanel();
        dotpanel7.setBackground(Color.decode("#00FF00"));
        dotpanel7.setBounds(323, 374, 33, 33);
        JPanel dotpanel8 = new JPanel();
        dotpanel8.setBackground(Color.decode("#00FF00"));
        dotpanel8.setBounds(294, 506, 33, 33);
        JPanel dotpanel9 = new JPanel();
        dotpanel9.setBackground(Color.decode("#00FF00"));
        dotpanel9.setBounds(340, 636, 33, 33);
        JPanel dotpanel10 = new JPanel();
        dotpanel10.setBackground(Color.decode("#00FF00"));
        dotpanel10.setBounds(444, 724, 33, 33);
        JPanel dotpanel11 = new JPanel();
        dotpanel11.setBackground(Color.decode("#00FF00"));
        dotpanel11.setBounds(579, 750, 33, 33);
        JPanel dotpanel12 = new JPanel();
        dotpanel12.setBackground(Color.decode("#00FF00"));
        dotpanel12.setBounds(707, 705, 33, 33);
        JPanel dotpanel13 = new JPanel();
        dotpanel13.setBackground(Color.decode("#00FF00"));
        dotpanel13.setBounds(804, 598, 33, 33);
        JPanel dotpanel14 = new JPanel();
        dotpanel14.setBackground(Color.decode("#00FF00"));
        dotpanel14.setBounds(845, 458, 33, 33);
        JPanel dotpanel15 = new JPanel();
        dotpanel15.setBackground(Color.decode("#00FF00"));
        dotpanel15.setBounds(823, 310, 33, 33);
        JPanel dotpanel16 = new JPanel();
        dotpanel16.setBackground(Color.decode("#00FF00"));
        dotpanel16.setBounds(740, 188, 33, 33);
        JPanel dotpanel17 = new JPanel();
        dotpanel17.setBackground(Color.decode("#00FF00"));
        dotpanel17.setBounds(617, 113, 33, 33);
        JPanel dotpanel18 = new JPanel();
        dotpanel18.setBackground(Color.decode("#00FF00"));
        dotpanel18.setBounds(472, 94, 33, 33);
        JPanel dotpanel19 = new JPanel();
        dotpanel19.setBackground(Color.decode("#00FF00"));
        dotpanel19.setBounds(332, 138, 33, 33);
        JPanel dotpanel20 = new JPanel();
        dotpanel20.setBackground(Color.decode("#00FF00"));
        dotpanel20.setBounds(219, 237, 33, 33);

        //==============================================================================================================

        JFrame frame = new JFrame();
        frame.setTitle("Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the program when the window is closed
        frame.setResizable(true); // Prevent the user from resizing the window
        frame.setLayout(null); // Set the layout manager to null
        frame.setSize(1650,1080); // Set the size of the window to full screen
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        
        frame.setVisible(true);
        frame.add(losePanel); frame.add(winPanel); frame.add(danPanel);
        frame.add(ePanel); frame.add(mpanel1); frame.add(mpanel2); frame.add(mpanel3); frame.add(mpanel4);
        frame.add(tree); frame.add(centerpanel);
        frame.add(dotpanel1); frame.add(dotpanel2); frame.add(dotpanel3); frame.add(dotpanel4); frame.add(dotpanel5);
        frame.add(dotpanel6); frame.add(dotpanel7); frame.add(dotpanel8); frame.add(dotpanel9); frame.add(dotpanel10);
        frame.add(dotpanel11); frame.add(dotpanel12); frame.add(dotpanel13); frame.add(dotpanel14); frame.add(dotpanel15);
        frame.add(dotpanel16); frame.add(dotpanel17); frame.add(dotpanel18); frame.add(dotpanel19); frame.add(dotpanel20);
        frame.add(bluepanel);
        frame.add(aPanel);
        frame.add(treepanel);
        frame.add(purPanel);
        frame.add(redpanel);
        frame.add(yellowpanel);
        frame.add(orangepanel); 
        playBackgroundMusic("D:\\VGU\\Third_year\\OOP_Java\\Game3\\Images\\PvZ.wav");
    }
}