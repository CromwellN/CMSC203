/** 
*The purpose of this class is to model a television
*Cromwell Nzouakeu and 09/20/2020
*/
 
public class Television {
	
		private final String MANUFACTURER;
		private final int SCREEN_SIZE;
		private boolean powerOn;
		private int channel;
		private int volume;

		public Television(String brand, int size) {
			this.MANUFACTURER = brand;
			this.SCREEN_SIZE = size;
			this.powerOn = false;
			this.channel = 2;
			this.volume = 20;
		}
		public void setChannel(int channel) {
			this.channel = channel;
		}
		public void power() {
			powerOn = !powerOn;
		}
		public void increaseVolume() {
			this.volume++;
		}
		public void decreaseVolume() {
			this.volume--;
		}
		public int getChannel() {
			return channel;
		}
		public int getVolume() {
			return volume;
		}
		public String getManufacturer() {
			return MANUFACTURER;
		}
		public int getScreenSize() {
			return SCREEN_SIZE;
		}	
		
	}
