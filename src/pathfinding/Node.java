package pathfinding;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Label;
import de.ur.mi.graphics.Rect;
import main.Settings;

public class Node {
	
	private int h_cost;
	private int id;
	private int xCoord;
	private int yCoord;
	private String chessCoord;
	private int orientation;
	private boolean isObstacle;
	private int f_cost;
	private int g_cost;
	private Color color;
	private Color originalColor;
	private Node parent;
	private boolean showLabels;



	
	public Node(int id, int xCoord, int yCoord, String chessCoord, int orientation){
		this.id = id;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.chessCoord = chessCoord;
		this.isObstacle = false;
		this.f_cost = Integer.MAX_VALUE;
		this.g_cost = 0;
		this.showLabels = Settings.showLabels();
		this.parent = null;
	}
	
	
	public void setOrientation(int orientation){
		
			
			this.orientation = orientation;
			
	}
	
	
	public int getOrientation(){
		return orientation;
	}


	
	public String getChessCoord() {
		return chessCoord;
	}
	
	public int getYCoord() {
		return yCoord;
	}

	public int getXCoord() {
		return xCoord;
	}

	
	public void setObstacle(boolean b){
		isObstacle = true;
	}
	public boolean isObstacle(){
		return isObstacle;
	}
	public int getId() {
		return id;
	}

	public String toCoordString() {
		return yCoord+","+xCoord;
	}
	
	public void setFCost(int f_cost){
		if(f_cost < this.f_cost){
			this.f_cost = f_cost;
		}
	}
	public void setGCost(int g_cost){
		
			this.g_cost = g_cost;
		
		
	}
	
	public int getFCost(){
		return f_cost;
	}
	
	public int getGCost(){
		return g_cost;
	}
	
	public void setOrientationByString(String direction) {
		switch (direction) {
		case "top":
			setOrientation(0);
			break;
		case "bottom":
			setOrientation(180);
			break;
		case "left":
			setOrientation(270);
			break;
		case "right":
			setOrientation(90);
			break;
		default:
			break;
		}
	}
	
	public void setColor(Color c){
		if(color == null){
			originalColor = c;
		}
		
		
		color = c;
	}
	public Color getColor(){
		return color;
	}
	
	public void resetColor(){
		if(color != Settings.getColorObstacle()){
			color = originalColor;
		}
		
	}
	
	public void draw(){
	
		
		int y = getYCoord(); 
		int x = getXCoord();
		 if(y != 0){
			 y *= Settings.getFieldHeight();
		 }
		 if(x != 0){
			 x *= Settings.getFieldHeight();
		 }
		 int label_x = x+Settings.getFieldHeight();
		 drawTile(x,y);
		 if(showLabels){
			 drawLabels(label_x,y); 
		 }
		

		
		
	}
	
	private void drawLabels(int x, int y) {
		this.h_cost = AStar.calculateCostH(this);
		
		Color labelColor;
		if(color ==Settings.getColorChessA() && !isObstacle){
			labelColor = Settings.getColorChessB();
		}else if(color == Settings.getColorChessB() && !isObstacle){
			labelColor = Settings.getColorChessA();
		}else if(color == Settings.getColorMovement()){
			labelColor = Color.BLACK;
		}else if(isObstacle){
			labelColor = Color.ORANGE;
		}else{
			labelColor = Color.WHITE;
		}
	 	Label chess = new Label(y+2,x-2, getChessCoord(),labelColor );
		chess.setFontSize(Settings.getFontSizeChess());
		chess.draw();
		
		Label h = new Label(y+35,x-35, Integer.toString(getHCost()), labelColor);
		h.setFontSize(Settings.getFontSizeLabel());
		h.draw();

		
		if(getFCost() < Integer.MAX_VALUE){
			Label f = new Label(y+16,x-20, Integer.toString(getFCost()), Color.BLACK);
			f.setFontSize(Settings.getFontSizeLabel());
			f.draw();
		}
		
		if(getGCost() >0){
			Label g = new Label(y+2,x-35,Integer.toString(getGCost()), labelColor);
			g.setFontSize(Settings.getFontSizeLabel());
			g.draw();

		}
	}


	private void drawTile(int x, int y) {
		Rect rect = new Rect(y, x, Settings.getFieldHeight(), Settings.getFieldHeight(),getColor());
		if(Settings.getBorder()){
			rect.setBorder(Settings.getBorderColor(), 1);
		}
	
		rect.draw();
	}


	public int getHCost() {
		
		return h_cost;
	}
	public void setHCost(int cost) {
		this.h_cost = cost;
	}

	public void updateNode(Node currentNode, int orientation) {
		currentNode.setOrientation(orientation);
		currentNode.setColor(Settings.getColorMovement());
		
	}

	public String getOrientationString() {
		switch (getOrientation()) {
		case 0:
			return "top";
		case 90:
			return "right";
		case 180:
			return "bottom";
		case 270:
			return "left";
		default:
			return "top";
		}
	}


	public void setParentNode(Node node) {
		this.parent=node;	
	}
	
	public Node getParent(){
		return parent;
	}
}
