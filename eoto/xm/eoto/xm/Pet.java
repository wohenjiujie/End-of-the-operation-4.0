package eoto.xm;

import java.util.*;

abstract class Pet implements Feed,Game,Treat{
	private String Name;
	private String Type;
	private int Health_Value;
	private int Intimacy=0;
	private int Physical_Strength=100;
	
	protected void initialName(String Name) {
		this.Name=Name;
	}
	protected void initialType(String type) {
		this.Type=type;
	}
	protected void initialHealth(int hv) {
		this.Health_Value=hv;
	}
	protected void initialIntimacy(int inti) {
		this.Intimacy=inti;
	}
	protected void initialPhysical(int ps) {
		this.Physical_Strength=ps;
	}
	protected String getName() {
		return this.Name;
	}
	protected void setType(int te,int x) {
		if(x==1) {
			this.Type=Attributes.dogType(te);
		}
		if(x==2) {
			this.Type=Attributes.penguinType(te);
		}
		if(x==3) {
			this.Type=Attributes.catType(te);
		}
	}
	protected String getType() {
		return Type;
	}
	protected boolean setHealth(boolean m) {
		boolean cor=true;
		if(m) {
			while(getHealth()<=60) {
				this.Health_Value=getHealth()+20;
			}
			}
		else {
			final int max=100;
			final int min=0;
			Random random=new Random();
			int hv=random.nextInt(max)%(max-min+1)+min;
			while(hv>getHealth()) {
				hv=random.nextInt(max)%(max-min+1)+min;		
				}
			this.Health_Value=hv;
			}
		return cor;
	}
	protected int getHealth() {
		return Health_Value;
	}
	protected void setIntimacy(boolean k) {
		if(k) {
			this.Intimacy=getIntimacy()+10;
		}
		else {
			this.Intimacy=getIntimacy()-5;
		}
	}
	protected int getIntimacy() {
		return Intimacy;
	}
	protected boolean setPS(boolean l) {
		boolean cor=true;
		if(l) {
			if(getPS()>=100) {
				cor=false; 
			}
			else {
				this.Physical_Strength=getPS()+5;
				if(this.Physical_Strength>100) {
					this.Physical_Strength=100;
				}
				cor=true;
			}
		}
		else {
			if(getPS()<60) {
				cor=false;
			}
			else {
				this.Physical_Strength=getPS()-5;
				cor=true;
			}
		}
		return cor;
	}
	protected int getPS() {
		return this.Physical_Strength;
	}
	public int feed() {
		final boolean k=true;
		int cor=0;
		if(getHealth()<60||getPS()<60) {
			cor=2;
		}
		else {
			if(!setPS(k)) {
				cor=1;
			}
			else {
				setIntimacy(k);
				this.Health_Value=getHealth()+1;
				if(this.Health_Value>100) {
					this.Health_Value=100;
				}
				
			}
		}
		return cor;
	}
	public int game() {
		final boolean k=true;
		int cor=0;
		if(getHealth()<60||getPS()<60) {
			cor=2;
		}
		else {
			if(!setPS(!k)) {
				cor=1;
			}
			else {
				setIntimacy(k);
				this.Health_Value=getHealth()+1;
				if(this.Health_Value>100) {
					this.Health_Value=100;
				}
			}
		}
		return cor;
	}
	public boolean treat() {
		final boolean k=true;
		boolean cor=true;
		if(getPS()<60||getHealth()<60) {
			setIntimacy(!k);
			setHealth(k);
			this.Physical_Strength=100;
			cor=true;
		}
		else {
			cor=false;
		}
		return cor;
	}
}
