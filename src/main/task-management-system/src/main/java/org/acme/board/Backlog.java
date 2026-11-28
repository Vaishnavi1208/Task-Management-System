package org.acme.board;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "backlogs", schema = "public")
@DiscriminatorValue("BACKLOG")
@PrimaryKeyJoinColumn(name = "board_id")
public class Backlog extends Board {

  protected Backlog() {}

  public Backlog(String name) {
    super(name);
  }
}
