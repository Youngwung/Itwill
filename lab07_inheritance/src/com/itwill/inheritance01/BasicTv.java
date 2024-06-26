package com.itwill.inheritance01;

// extends Object는 생략 가능.(거의 생략함)
public class BasicTv {
	// 상수 정의:
	public static final int MIN_CHANNEL = 0;
	public static final int MAX_CHANNEL = 2;

	public static final int MIN_VOLUME = 0;
	public static final int MAX_VOLUME = 2;

	// 필드
	private boolean powerOn; // 전원상태(true->ON, false->OFF)
	private int channel; // 현재 채널 번호
	private int volume; // 음량

	// 생성자
	public BasicTv() {
	}

	public BasicTv(boolean powerOn, int channel, int volume) {
		super();
		this.powerOn = powerOn;
		this.channel = channel;
		this.volume = volume;
	}

	// getter and setter
	public boolean isPowerOn() {
		return powerOn;
	}

	public void setPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	// 메서드

	/**
	 * TV가 켜져있으면 끄고, TV가 꺼져있으면 켬. powerOn의 값이 true이면 false로 변경하고, false이면 true로 변경.
	 * 
	 * @return powerOn
	 */
	public boolean powerOnOff() {
		if (powerOn) {
			powerOn = false;
			System.out.println("TV OFF");
		} else if (powerOn == false) {
			powerOn = true;
			System.out.println("TV ON");
		}
		return powerOn;
	}

	/**
	 * channelUp. 현재 채널의 값을 1 증가 만약 현재 채널 값이 채널의 최댓값(MAX_CHANNEL)인 경우, 채널의
	 * 최솟값(MIN_CHENNEL)으로 변경.
	 * 
	 * @return 바뀐 현재 채널 값.
	 */
	public int channelUp() {
		if (powerOn) {

			if (channel < MAX_CHANNEL) {
				channel++;
			} else {
				channel = MIN_CHANNEL;
			}
			System.out.println("CH: " + channel);
		}
		return channel;
	}

	/**
	 * channelDown. 현재 채널의 값을 1 감소 만약 현재 채널 값이 채널의 최솟값인 경우, 채널의 최댓값으로 변경.
	 * 
	 * @return 바뀐 현재 채널 값.
	 */
	public int channelDown() {
		if (powerOn) {
			if (channel > MIN_CHANNEL) {
				channel--;
			} else {
				channel = MAX_CHANNEL;
			}
			System.out.println("CH: " + channel);
		}
		return channel;
	}

	/**
	 * volumeUp. 현재 볼륨의 값을 1 증가 만약 현재 볼륨이 최댓값인 경우, 증가하지 않음.
	 * 
	 * @return 바뀐 현재 볼륨 값.
	 */
	public int volumeUp() {
		if (powerOn) {
			if (volume < MAX_VOLUME) {
				volume++;
			} 
			System.out.println("VOL: " + volume);
		}
		return volume;
	}

	/**
	 * volumeDown. 현재 볼륨의 값을 1 감소 만약 현재 볼륨이 최솟값인 경우, 감소하지 않음.
	 * 
	 * @return 바뀐 현재 볼륨 값.
	 */
	public int volumeDown() {
		if (powerOn) {
			if (volume > MIN_VOLUME) {
				volume--;
			} 
			System.out.println("VOL: " + volume);
		}
		return volume;
	}

}