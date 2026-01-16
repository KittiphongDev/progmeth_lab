package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit{
    public RangeUnit(int startColumn,int startRow, boolean isWhite, String name)
    {
        super(startColumn,startRow,isWhite,name);
        this.hp =2;
    }

    public void attack(ArrayList<BaseUnit> targetPieces)
    {
        for (BaseUnit u:targetPieces)
        {
            if (isWhite() && u.getColumn() == this.getColumn() && u.getRow() == this.getRow()+1)
            {
                System.out.println(this.getName() + " attacks " + u.getName());
                u.setHp(u.getHp()-power);
            }
            if (!isWhite() && u.getColumn() == this.getColumn() && u.getRow() == this.getRow()-1)
            {
                System.out.println(this.getName() + " attacks " + u.getName());
                u.setHp(u.getHp()-power);
            }
        }
    }


}
