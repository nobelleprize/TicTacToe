import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToeUI extends JPanel{
    JButton[] buttons;
    TicTacToeBoard game;

    public TicTacToeUI()
    {
        game = new TicTacToeBoard();
        setLayout(new GridLayout(3,3));
        buttons = new JButton[9];

        for(int i=0; i < 9; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setName(Integer.toString(i));
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonClicked());
            add(buttons[i]);
        }
    }

    private class buttonClicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int clicked = Integer.parseInt(((JComponent) e.getSource()).getName());

            String square = game.refreshBoard(clicked);
            buttons[clicked].setText(square);
            buttons[clicked].setEnabled(false);

            if(game.checkWinner() != null)
            {
                String m;
                if(game.checkWinner() == "tie")
                {
                    m = "Game is over. Tie.";
                }
                else
                {
                    m = "Game is over. " + game.checkWinner() + " won!";
                }

                int choice = JOptionPane.showOptionDialog(null,
                        m,
                        "Game Over",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new String[]{"Restart", "Cancel"},
                        "default");

                for(int i=0; i < 9; i++)
                {
                    buttons[i].setEnabled(false);
                }
                if(choice == 0)
                {
                    resetBoard();
                }
            }

        }
    }

    public void resetBoard()
    {
        for(int i=0; i < 9; i++)
        {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        game.resetBackEnd();
    }

    public static void main(String[] args)
    {
        JFrame window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TicTacToeUI());
        window.setBounds(300,200,500,500);
        window.setVisible(true);

    }
}
