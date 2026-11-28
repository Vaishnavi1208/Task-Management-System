package org.acme.sprint;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.time.LocalDate;
import org.acme.board.Board;

@Entity
@Table(name = "sprints", schema = "public")
@DiscriminatorValue("SPRINT")
@PrimaryKeyJoinColumn(name = "board_id")
public class Sprint extends Board {

  private String goal;

  private LocalDate startDate;

  private LocalDate endDate;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SprintStatus status = SprintStatus.PLANNED;

  protected Sprint() {}

  public Sprint(String name, String goal, LocalDate startDate, LocalDate endDate) {
    super(name);
    this.goal = goal;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public String getGoal() {
    return goal;
  }

  public void setGoal(String goal) {
    this.goal = goal;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public SprintStatus getStatus() {
    return status;
  }

  public void setStatus(SprintStatus status) {
    this.status = status;
  }
}
