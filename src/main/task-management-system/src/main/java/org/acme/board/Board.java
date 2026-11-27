package org.acme.board;

import java.util.ArrayList;
import org.acme.task.Task;

import jakarta.persistence.Entity;

@Entity 
public class Board {
    
    public ArrayList<Task> tasks;
    
}
