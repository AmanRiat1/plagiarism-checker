public class Jaccard implements Similarity{
	public double score(WordMap a, WordMap b){
		int aSize = a.size();

		double intersection = 0;
		double union = 0;
		String[] setElems; 

		setElems = a.keys();
		for (int i = 0; i < aSize; i++){
			if (b.contains(setElems[i])){
				intersection++;
			}	
		}

		union = a.size() + b.size() - intersection;
		return (intersection/union);
	}

}