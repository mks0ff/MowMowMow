import Test.QuickCheck

data Move = LEFT | RIGHT | FORWARD deriving (Eq, Ord, Show, Bounded, Enum)

instance Arbitrary Move where
  arbitrary = do
    n <- choose (0,2) :: Gen Int
    return $ case n of
      0 -> LEFT
      1 -> RIGHT
      2 -> FORWARD

main :: IO [Move] -- todo add some quick check tests
main = do
    sample' arbitrary

