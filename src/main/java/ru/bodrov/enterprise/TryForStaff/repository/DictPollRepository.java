package ru.bodrov.enterprise.TryForStaff.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bodrov.enterprise.TryForStaff.model.DictPoll;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DictPollRepository {

    private Map<String, DictPoll> polls = new LinkedHashMap<>();

    @PostConstruct
    private void init(){
        merge(new DictPoll("Общий тест"));
        merge(new DictPoll("Тест для приема на работу"));
        merge(new DictPoll("Тест для программистов"));
    }

    @NotNull
    public Collection<DictPoll> getListPoll(){
        return polls.values();
    }


    public void merge(@Nullable final DictPoll poll){
        if(poll==null) return;
        if(poll.getId()==null||poll.getId().isEmpty()) return;
        polls.put(poll.getId(), poll);
    }

    public DictPoll findOne(@Nullable final String pollId){
        if(pollId==null||pollId.isEmpty()) return null;
        return polls.get(pollId);
    }

    public void removePollById(@Nullable final String pollId){
        if(pollId==null||pollId.isEmpty()) return;
        polls.remove(pollId);
    }
}
