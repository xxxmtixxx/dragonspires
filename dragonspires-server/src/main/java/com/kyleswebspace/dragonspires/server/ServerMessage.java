package main.java.com.kyleswebspace.dragonspires.server;

import java.io.Serializable;

/**
 * @author kyle.ouellette
 */
public class ServerMessage implements Serializable {

	private static final long serialVersionUID = 1185493340651322989L;
	
	private String position = null;
	private String actionType = null;
	private String actionString = null;
	
	
	public ServerMessage() {
		
	}
	
	public ServerMessage(String actionString) {
		this.actionString = actionString;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActionString() {
		return actionString;
	}

	public void setActionString(String actionString) {
		this.actionString = actionString;
	}
}
