package com.pxworlds.game.states;

import com.pxworlds.game.tilemap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;


public class MenuState extends GameState {

    private Background bg;
    private int currentChoice = 0;
    private String[] options = {
        "Start",
        "Help",
        "Quit"
    };

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;

        try {
            bg = new Background("/assets/backgrounds/startscreen/background.png", 1);
            bg.setVector(-0.1, 0);

            titleColor = new Color(128, 0 ,0);
            titleFont = new Font("Century Gothic", Font.PLAIN, 50);
            font = new Font("Century Gothic", Font.PLAIN, 30);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        bg.update();
    }

    @Override
    public void draw(Graphics2D g) {
        bg.draw(g);
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("pxWorlds", 290, 120);

        g.setFont(font);
        for(int i = 0; i < options.length; i++) {
            if(i == currentChoice) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            g.drawString(options[i], 360, 300 + i * 30);
        }
    }

    private void select() {
        if(currentChoice == 0) {

        }
        if(currentChoice == 1) {

        }
        if(currentChoice == 2) {
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_ENTER) {
            select();
        }
        if(k == KeyEvent.VK_UP) {
            currentChoice--;
            if(currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }
        if(k == KeyEvent.VK_DOWN) {
            currentChoice++;
            if(currentChoice == options.length) {
                currentChoice = 0;
            }
        }
    }

    @Override
    public void keyReleased(int k) {

    }
}
