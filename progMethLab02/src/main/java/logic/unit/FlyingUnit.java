package logic.unit;

import logic.game.GameSystem;

public class FlyingUnit extends BaseUnit{
    public FlyingUnit(int startColumn,int startRow, boolean isWhite, String name)
    {
        super(startColumn,startRow,isWhite,name);
        this.hp =2;
        this.isFlying = true;
    }

   private int[] nextPos = {0,0};

    @Override
    public boolean move(int direction)
    {
        if (direction <0 || direction >3) return false;
        switch (direction)
        {
            case 0:
                nextPos[0] = this.getRow() + 2 ;
                nextPos[1] = this.getColumn();
                break;
            case 1:
                nextPos[1] = this.getColumn() +2;
                nextPos[0] = this.getRow();
                break;
            case 2:
                nextPos[0] = this.getRow() -2;
                nextPos[1] = this.getColumn();
                break;
            case 3:
                nextPos[1] = this.getColumn() -2;
                nextPos[0] = this.getRow();
                break;
        }

        if (nextPos[0] < 0 || nextPos[1] < 0 || nextPos[0] >4 || nextPos[1]>4) return false;

        for (BaseUnit u: GameSystem.getInstance().getAllWhitePieces())
        {
            if(u.getRow() == nextPos[0] && u.getColumn() == nextPos[1])
            {
                return false;
            }
        }

        this.setRow(nextPos[0]);
        this.setColumn(nextPos[1]);

        return true;
    }

}
