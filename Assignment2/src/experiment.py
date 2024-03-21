import subprocess
import os
import random
class Experiment():
    SAMPLE = "../data/experiment.txt"
    def __init__(self, size):
        self.size = size
        Experiment.create_file(size)

    @staticmethod
    def create_file(size):
        with open("../data/GenericsKB.txt", "r") as f:
            lines = f.readlines()
        
        sampled_lines = random.sample(lines, size)
        
        with open(Experiment.SAMPLE, "w") as f:
            f.writelines(sampled_lines)   
    
    def run(self):
        subprocess.run(["make", "run", f"SOURCE={Experiment.SAMPLE}", "QUERY=../data/GenericsKB-queries.txt"])

def main():
    with open("../output/result.csv", "w"):
        pass
    avg_100 = Experiment(100)
    avg_100.run()
    avg_1000 = Experiment(1000)
    avg_1000.run()
    avg_10000 = Experiment(10000)
    avg_10000.run()
    
if __name__ == "__main__":
    main()