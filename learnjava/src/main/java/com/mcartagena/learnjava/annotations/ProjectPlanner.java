package com.mcartagena.learnjava.annotations;

@Deprecated(since="5.0")
public class ProjectPlanner<T> {
    ProjectPlanner create(T t) { return this; }
}

@SuppressWarnings({"deprecation","unchecked"})
class SystemPlanner {
    ProjectPlanner planner = new ProjectPlanner().create("TPS");
}
