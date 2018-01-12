package field;

import java.util.ArrayList;

import cell.Cell;

public class Field {
	private int width;
	private int height;
	private Cell[][] field;
	
	public Field(int width, int height) {		//构造函数，构造width,height,field;
		this.width = width;
		this.height = height;
		field = new Cell[height][width];		//通过函数对动态创建cell[][]对象数组，否则cell[][] field并未真的被创建，无意义
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public Cell place(int row, int col, Cell o) {
		Cell ret = field[row][col];
		field[row][col] = o;
		return ret;			//返回的是替换前原field[row][col]的cell对象；
	}
	
	public Cell get(int row, int col) {
		return field[row][col];
	}
	
	public Cell[] getNeighbour(int row, int col) {
		ArrayList<Cell> list = new ArrayList<Cell>();
		for ( int i=-1; i<2; i++ ) {			//双循环遍历9宫格；
			for ( int j=-1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if ( r >-1 && r<height && c>-1 && c<width && !(r== row && c == col)/*排除中心点*/ ) {
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()]);		//返回邻居九宫格的对象的数组（不包含自己）
	}
	
	public void clear() {		//双循环清空filed；
		for ( int i=0; i<height; i++ ) {
			for ( int j=0; j<width; j++ ) {
				field[i][j] = null;
			}
		}
	}
}
