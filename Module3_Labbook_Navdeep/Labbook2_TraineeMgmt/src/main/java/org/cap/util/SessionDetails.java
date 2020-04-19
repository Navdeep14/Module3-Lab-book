package org.cap.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionDetails {
	private int id=-1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
