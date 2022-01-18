package com.app.apiaccessparty.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document("email")
public class EmailEnviado implements Serializable{

	private static final long serialVersionUID = -8915974898512866484L;

	@Id
	private String id;
	
	private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime sendDateEmail;
    private Boolean statusEmail;
}
