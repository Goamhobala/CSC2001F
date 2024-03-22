import subprocess
import random
import numpy as np
import matplotlib.pyplot as plt
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

# class Line():
#     def __init__(self, data):
        
        

def readData():
    with open("../output/result.csv", "r") as f:
        lines = f.readlines()
    data = []
    for line in lines:
        data.append(line.split(","))
    
    return data

def main():
    with open("../output/result.csv", "w"):
        pass
    i = 1
    experiments = []
    x = []
    while (i <= 50000):
        experiment = Experiment(i)
        experiment.run()
        experiments.append(experiment)
        i *= 3
        x.append(i)
    data = readData()
    y = [datum[2] for datum in data]
    plt.plot(x, y)
    plt.show()
    
    
    

if __name__ == "__main__":
    main()