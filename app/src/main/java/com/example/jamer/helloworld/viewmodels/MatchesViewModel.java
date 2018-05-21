package com.example.jamer.helloworld.viewmodels;

import com.example.jamer.helloworld.datamodels.MatchesDataModel;
import com.example.jamer.helloworld.models.Matches;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MatchesViewModel {

    private MatchesDataModel matchesModel;

    public MatchesViewModel() {
        matchesModel = new MatchesDataModel();
    }

    public void getMatchesItems(Consumer<ArrayList<Matches>> responseCallback) {
        matchesModel.getMatchesItems(
                (DataSnapshot dataSnapshot) -> {
                    ArrayList<Matches> matchesArr = new ArrayList<>();
                    for (DataSnapshot matchesSnapshot : dataSnapshot.getChildren()) {
                        Matches item = matchesSnapshot.getValue(Matches.class);
                        assert item != null;
                        item.uid = matchesSnapshot.getKey();
                        matchesArr.add(item);
                    }
                    responseCallback.accept(matchesArr);
                },
                (databaseError -> System.out.println("Error reading Matches Items: " + databaseError))
        );
    }

    public void updateMatchesItem(Matches item) {
        matchesModel.updateMatchesItemById(item);
    }

    public void clear() {
        matchesModel.clear();
    }
}
