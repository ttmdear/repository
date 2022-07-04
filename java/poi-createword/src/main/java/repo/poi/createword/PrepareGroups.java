package repo.poi.createword;

import repo.poi.createword.model.ApiSchema;
import repo.poi.createword.model.Group;
import repo.poi.createword.model.GroupItem;
import repo.poi.createword.model.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrepareGroups {
    public PrepareGroups() {
    }

    public List<Group> prepare(ApiSchema apiSchema) {
        Map<String, Group> groups = new HashMap<>();

        for (Map.Entry<String, Map<String, Operation>> entry1 : apiSchema.getPaths().entrySet()) {
            for (Map.Entry<String, Operation> entry2 : entry1.getValue().entrySet()) {
                Operation operation = entry2.getValue();

                if (operation.hasTags()) {
                    for (String tag : operation.getTags()) {
                        addGroup(entry1.getKey(), entry2.getKey(), tag, operation, groups);
                    }
                } else {
                    addGroup(entry1.getKey(), entry2.getKey(), "Other", operation, groups);
                }
            }
        }

        return new ArrayList<>(groups.values());
    }

    private void addGroup(String path, String method, String tag, Operation operation, Map<String, Group> groups) {
        if (!groups.containsKey(tag)) {
            groups.put(tag, new Group(tag, new ArrayList<>()));
        }

        groups.get(tag).getItems().add(new GroupItem(method, path, operation));
    }

    private String resolveGroupName(List<String> tags) {
        if (tags == null || tags.isEmpty()) {
            return "Rest";
        }

        return null;
    }
}
