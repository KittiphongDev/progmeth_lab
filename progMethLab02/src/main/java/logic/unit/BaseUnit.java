package logic.unit;

import logic.game.GameSystem;

import java.util.ArrayList;

public class BaseUnit {

    private int row;
    private int column;
    private boolean isWhite;
    private String name;
    protected int hp;
    protected int power;
    protected boolean isFlying;
    private int[] nextPos = {0,0};

    public BaseUnit(int startColumn, int startRow, boolean isWhite, String name)
    {
        this.power = 1;
        this.isFlying = false;
        this.hp =2;
        this.column = startColumn;
        this.row = startRow;
        this.name = name;
        this.isWhite = isWhite;
    }

    public boolean move(int direction)
    {

        if (direction <0 || direction >3) return false;
        switch (direction)
        {
            case 0:
                nextPos[0] = this.getRow() + 1 ;
                nextPos[1] = this.getColumn();
                break;
            case 1:
                nextPos[1] = this.getColumn() +1;
                nextPos[0] = this.getRow();
                break;
            case 2:
                nextPos[0] = this.getRow() -1;
                nextPos[1] = this.getColumn();
                break;
            case 3:
                nextPos[1] = this.getColumn() -1;
                nextPos[0] = this.getRow();
                break;
        }

        if (nextPos[0] < 0 || nextPos[1] < 0 || nextPos[0] >4 || nextPos[1]>4) return false;

        for (BaseUnit u:GameSystem.getInstance().getAllWhitePieces())
        {
            if(u.row == nextPos[0] && u.column == nextPos[1])
            {
                return false;
            }
        }
        for (BaseUnit u:GameSystem.getInstance().getAllRedPieces())
        {
            if(u.row == nextPos[0] && u.column == nextPos[1])
            {
                return false;
            }
        }

        row = nextPos[0];
        column = nextPos[1];

        return true;
    }

    public void attack(ArrayList<BaseUnit> targetPieces)
    {
        for (BaseUnit b:targetPieces)
        {
            if (!b.isFlying && b.row == row && b.column == column)
            {
                System.out.println(this.getName() + " attacks " + b.getName());
                b.setHp(b.getHp()-power);
            }
        }
    }

    public int getRow() {
        if (row <0)
        {
            return 0;
        }
        if (row >4)
        {
            return 4;
        }
        return row;
    }

    public void setRow(int row) {
        if (row <0)
        {
            this.row = 0;
        }
        else if (row >4)
        {
            this.row = 4;
        }
        else{
            this.row = row;
        }
    }

    public int getColumn() {
        if (column <0)
        {
            return 0;
        }
        if (column >4)
        {
            return 4;
        }
        return column;
    }

    public void setColumn(int column) {
        if (column <0)
        {
            this.column = 0;
        }
        else if (column >4)
        {
            this.column = 4;
        }
        else{
            this.column = column;
        }
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public boolean isFlying() {
        return isFlying;
    }
}
