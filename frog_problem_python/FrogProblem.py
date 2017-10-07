# This program solves the frog problem
# Initial state: 1110222 (represents three green frogs, followed by an empty rock, followed by three red frogs)
# Goal state: 2220111
# Legal moves:
#   Green frog (1) can move to the left if:
#    1) next rock is empty
#    2) next rock is full and the rock after next is empty
#   Red frog (2) can move to the right if:
#    1) previous rock is empty
#    2) previous rock is full and the rock before previous is empty


import collections


# The following class represents a state of the problem
class State:

    def __init__(self, string):
        self.pos = string

    def __str__(self):
        return self.pos

    def is_goal(self):
        if self.pos == "2220111":
            return True
        return False

    # Method to make a legal move for green frog (1)
    # loc represents the location at which the frog currently is
    # returns new state if move is possible, else returns None
    def move1right(self, loc):
        # if the frog on location is of wrong color OR
        # frog is on last rock OR
        # frog is on location 5 and location 6 is full
        if (self.pos[loc] != "1") | (loc == 6) | ((loc == 5) & (self.pos[6] != "0")):
            return  # cannot move
        else:
            if self.pos[loc+1] == "0":  # if next loc is empty
                return State(self.pos[:loc]+"01"+self.pos[loc+2:])  # make move
            else:  # if next loc is not empty
                if self.pos[loc+2] == "0":
                    return State(self.pos[:loc]+"0"+self.pos[loc+1]+"1"+self.pos[loc+3:])
                return  # cannot move

    # Method to make a legal move for red frog (2)
    # loc represents the location at which the frog currently is
    # returns new state if move is possible, else returns None
    def move2left(self, loc):
        # if the frog on location is of wrong type OR
        # frog is on first rock OR
        # frog is on location 1 and location 0 is full
        if (self.pos[loc] != "2") | (loc == 0) | ((loc == 1) & (self.pos[0] != "0")):
            return  # cannot move
        else:
            if self.pos[loc-1] == "0":  # if prev loc is empty
                return State(self.pos[:loc-1]+"20"+self.pos[loc+1:])
            else:  # next loc is not empty
                if self.pos[loc-2] == "0":
                    return State(self.pos[:loc-2]+"2"+self.pos[loc-1]+"0"+self.pos[loc+1:])
                return  # can't move

    # Method returns the list of all children states of the current state that are not None
    def explore(self):
        children = list()
        for i in range(7):
            if self.move1right(i) is not None:
                children.append(self.move1right(i))
            if self.move2left(i) is not None:
                children.append(self.move2left(i))
        return children


# This class has methods for searching algorithms (BFS, DLS, DFS, IDS) and counters to count the nodes they generate:
class Traversals:
    def __init__(self):
        self.count_bfs = 0
        self.count_dfs = 0
        self.count_dls = 0
        self.count_ids = 0

    # Method to clear counters
    def clear_counters(self):
        self.count_bfs = 0
        self.count_dfs = 0
        self.count_dls = 0
        self.count_ids = 0

    # Breadth first search
    # terminates when goal found or all nodes visited
    def bfs(self, state):
        print(state)
        if state.is_goal():
            print("Goal reached!")
            return state
        to_visit = collections.deque()  # use as a FIFO queue
        to_visit.appendleft(state)  # add at end

        while len(to_visit) != 0:
            state = to_visit.pop()  # remove from front
            children = state.explore()
            for child in children:
                print(child)
                self.count_bfs=self.count_bfs+1
                if child.is_goal():
                    print("Goal reached!")
                    return child
                to_visit.appendleft(child)  # add at end

    # Depth first search
    # terminates when goal is found or all possible states have been visited (can get stuck in a loop if one exists)
    def dfs(self, state):
        print(state)
        if state.is_goal():
            print("Goal reached! ")
            return state
        to_visit = collections.deque()  # use as a LIFO queue/stack
        to_visit.append(state)  # add at front

        while len(to_visit) != 0:
            state = to_visit.pop()  # remove from front
            children = state.explore()
            for child in children:
                print(child)
                self.count_dfs = self.count_dfs + 1
                if child.is_goal():
                    print("Goal reached! ")
                    return child
                to_visit.appendleft(child)  # add at front

    # Depth limited search
    # terminates when limit reached or goal found
    def dls(self,limit, state):
        print(state)
        if state.is_goal():
            print("Goal reached!")
            return state
        elif limit == 0:  # base case
            return None
        else:
            children = state.explore()
            for child in children:
                self.count_dls = self.count_dls + 1  # counting generated nodes
                result = self.dls(limit - 1, child)
                if result is not None:
                    return result
            return None

    # Iterative deepening search
    # terminates only when goal state is found
    def ids(self, state):
        i = 0
        while not state.is_goal():
            temp = self.dls(i, state)
            if temp is not None:
                state = temp
            self.count_ids = i + self.count_dls
            i = i+1
        # goal reached by this point
        print("limit: ",i-1)
        return state


# ASSIGNMENT #

start = State("1110222")
traversals=Traversals()

# searching via different strategies

traversals.bfs(start)
print("Number of new nodes generated by BFS =",traversals.count_bfs,"\n")

traversals.dfs(start)
print("Number of new nodes generated by DFS =",traversals.count_dfs,"\n")

limit_for_dls = 15  # goal reached when 15 and above
traversals.dls(limit_for_dls, start)
print("Number of new nodes generated by DLS with limit",limit_for_dls,"=",traversals.count_dls,"\n")

traversals.clear_counters() # necessary to do since IDS uses DLS

traversals.ids(start)
print("Number of new nodes generated by IDS =",traversals.count_ids)