package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AmigosClave implements Serializable{

	@Column(name= "usuario_id")
	long userId;
	
	@Column(name = "amigo_id")
	long friendsId;
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getFriendsId() {
		return friendsId;
	}

	public void setFriendsId(long friendsId) {
		this.friendsId = friendsId;
	}


	
}
