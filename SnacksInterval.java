package ticketbooking;

enum SnacksInterval {
	POPCORN(50.0 , "Medium") , BUTTERPOPCORN(75.0 , "Medium") , ICECREAM(50.0 , "Medium") , COCOCOLA(60.0  , "60ml");
	
	private double cost;
	private String size ;
	SnacksInterval(double cost , String size ){
		this.cost = cost ;
		this.size = size ;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void showSnackBoard() {
		System.out.println();
		System.out.println(String.format("SNACK  : %s%nRATE  : %s%nSIZE  : %s",this,this.getCost(),this.getSize()));
		System.out.println("----------------------");
	}
}
