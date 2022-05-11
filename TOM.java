package library.tom;

import library.domain.DomainFactory;
import library.domain.Game;
import library.domain.Ship;
import library.domain.Space;

//this object is the main wrapper for the game TOM
public class TOM extends Node {

	//optional field
	private Integer startTimestamp = null;
	private Integer endTimestamp = null;

	public static class Builder {

		private Integer startTimestamp = null;
		private Integer endTimestamp = null;
		
		private Game game = new Game();
		
		public Builder withStartTimestamp(Integer startTimestamp) {
			this.startTimestamp = startTimestamp;
			return this;
		}
		
		public Builder withEndTimestamp(Integer endTimestamp) {
			this.endTimestamp = endTimestamp;
			return this;
		}
		
		public Builder withSpace() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
			this.game.appendChild((Space) new DomainFactory().get("library.domain.Space"));
			return this;
		}
		
		public Builder withShip() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
			this.game.getFirstChild().appendChild((Ship) new DomainFactory().get("library.domain.Ship"));
			return this;
		}
		

		public TOM build() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
			TOM tom = new TOM();
			if (this.startTimestamp!=null) {
				tom.startTimestamp = this.startTimestamp;
			}
			if (this.endTimestamp!=null) {
				tom.endTimestamp = this.endTimestamp;
			}
			tom.appendChild(this.game);
			return tom;
		}

	}

	@Override
	public String toString() {
		String str = "";
		str = "TOM [" + this.getFirstChild().getClass() +  "] ";
		if(this.getFirstChild().getFirstChild()!=null) {
			str = str+ "["+this.getFirstChild().getFirstChild().getClass()+"] ";
		}
		if(this.getFirstChild().getFirstChild().getFirstChild()!=null) {
			str = str+ "["+this.getFirstChild().getFirstChild().getFirstChild().getClass()+"]";
		}
		return str;
	}


	
	

}
