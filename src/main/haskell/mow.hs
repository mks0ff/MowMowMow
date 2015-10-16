module MowMowMow where

-- author sofiane

data Direction = NORTH | EAST | SOUTH | WEST deriving (Eq, Ord, Show, Bounded, Enum)

left :: Direction -> Direction
left NORTH = WEST
left direction = pred direction

right :: Direction -> Direction
right WEST = NORTH
right direction = succ direction

data Lawn = Lawn { max_x :: Int, max_y :: Int } deriving (Eq, Show)
data Position = Position { x :: Int, y :: Int, direction :: Direction } deriving (Eq, Show)
data Mower = Mower { lawn :: Lawn, position :: Position } deriving (Eq, Show)

contains_position :: Lawn -> Position -> Bool
contains_position (Lawn {max_x = lx, max_y = ly}) (Position {x = px, y = py, direction = _}) = (lx >= px && ly >= py && px >= 0 && py >= 0)

data Move = LEFT | RIGHT | FORWARD deriving (Eq, Ord, Show, Bounded, Enum)

update_direction :: Position -> Direction -> Position
update_direction (Position {x = px, y = py, direction = dir}) NORTH = Position px (py + 1) dir
update_direction (Position {x = px, y = py, direction = dir}) WEST = Position (px - 1) py dir
update_direction (Position {x = px, y = py, direction = dir}) EAST = Position (px + 1) py dir
update_direction (Position {x = px, y = py, direction = dir}) SOUTH = Position px (py -1) dir

update_position_in_lawn :: Lawn -> Position -> Move -> Position
update_position_in_lawn lawn position move
    | contains_position lawn new_position = new_position -- check every new position
    | otherwise = position -- don't move !
    where new_position = update_position position move

update_position :: Position -> Move -> Position
update_position (Position {x = px, y = py, direction = dir}) LEFT = Position px py (left dir)
update_position (Position {x = px, y = py, direction = dir}) RIGHT = Position px py (right dir)
update_position (Position {x = px, y = py, direction = dir}) FORWARD = update_direction (Position px py dir) dir

move_mower :: Lawn -> Position -> [Move] -> Position
move_mower lawn position moves = foldl (update_position_in_lawn lawn) position moves

move_mower_in_lawn :: Lawn -> Position -> [Move] -> Position
move_mower_in_lawn lawn position moves
    | contains_position lawn position = move_mower lawn position moves -- check the initial position
    | otherwise = position -- don't move !

move_mower_ :: Mower -> [Move] -> Position
move_mower_ (Mower {lawn = l, position = pos}) moves = move_mower l pos moves

main = do
    let lawn = Lawn 5 5 -- define our lawn
        position = Position 3 3 EAST -- define our initial position
        mower = Mower lawn position -- define our mower
    move_mower_ mower [FORWARD, FORWARD, RIGHT, FORWARD, FORWARD, RIGHT, FORWARD, RIGHT, RIGHT, FORWARD] -- let's move that shit !