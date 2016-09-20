/**
 * 
 */
package com.tc.common;

import java.util.concurrent.TimeUnit;

import org.apache.http.conn.ClientConnectionManager;

/**
 *  释放空闲的http链接.
 */

public class AbortConnectionThread extends Thread {

	private ClientConnectionManager ccm;
	
	private boolean stop = false;
	
	/**
	 * 
	 */
	public AbortConnectionThread(ClientConnectionManager cm) {
		super();
		this.ccm = cm;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		
		try {

			while (!stop) {
				synchronized (this) {
					wait(90000);
					
					// 关闭过期连接
					ccm.closeExpiredConnections();
					// 可选地，关闭空闲超过30秒的连接
					ccm.closeIdleConnections(60, TimeUnit.SECONDS);
				}
			}

		} catch (InterruptedException ex) {

			 // 终止

		}
	}
	
	public void stopAbort(){
		stop = true;
		synchronized (this) {
			notifyAll();
		}
	}
	

}
