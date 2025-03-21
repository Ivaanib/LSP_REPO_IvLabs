package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an electronic voting machine that tracks votes for candidates.
 */
public class VotingMachine {
    private Map<String, Integer> votes;

    public VotingMachine() {
        votes = new HashMap<>();
    }

    /**
     * Adds a candidate to the voting machine.
     * @param name the name of the candidate
     */
    public void addCandidate(String name) {
        votes.putIfAbsent(name, 0);
    }

    /**
     * Casts a vote for a candidate.
     * @param name the name of the candidate
     * @return true if the vote was successful, false if the candidate doesn't exist
     */
    public boolean castVote(String name) {
        if (votes.containsKey(name)) {
            votes.put(name, votes.get(name) + 1);
            return true;
        }
        return false;
    }

    /**
     * Displays the total votes for each candidate.
     */
    public void displayResults() {
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    /**
     * Determines the winner of the election.
     * @return a string announcing the winner and their vote count
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner != null ? winner + " WINS with " + maxVotes + " votes!!" : "No votes cast.";
    }
}