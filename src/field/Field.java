package field;

import java.util.ArrayList;

import cell.Cell;

public class Field {
	private int width;
	private int height;
	private Cell[][] field;
	
	public Field(int width, int height) {		//���캯��������width,height,field;
		this.width = width;
		this.height = height;
		field = new Cell[height][width];		//ͨ�������Զ�̬����cell[][]�������飬����cell[][] field��δ��ı�������������
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public Cell place(int row, int col, Cell o) {
		Cell ret = field[row][col];
		field[row][col] = o;
		return ret;			//���ص����滻ǰԭfield[row][col]��cell����
	}
	
	public Cell get(int row, int col) {
		return field[row][col];
	}
	
	public Cell[] getNeighbour(int row, int col) {
		ArrayList<Cell> list = new ArrayList<Cell>();
		for ( int i=-1; i<2; i++ ) {			//˫ѭ������9����
			for ( int j=-1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if ( r >-1 && r<height && c>-1 && c<width && !(r== row && c == col)/*�ų����ĵ�*/ ) {
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()]);		//�����ھӾŹ���Ķ�������飨�������Լ���
	}
	
	public void clear() {		//˫ѭ�����filed��
		for ( int i=0; i<height; i++ ) {
			for ( int j=0; j<width; j++ ) {
				field[i][j] = null;
			}
		}
	}
}
