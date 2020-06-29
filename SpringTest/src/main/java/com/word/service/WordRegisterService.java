package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {
	
	// @Resource
	// @Autowired
	// @Qualifier("usedDao") - 여러개의 같은 타입의 bean들 중에 주입할 특정 bean을 지정함. -> @Named(value="wordDao1")로 대체가능
	// @Autowired(required=false) - 있으면 주입하고 없으면 무시함 (익셉션을 피할수잇음)
	//  @Inject -  Autowired와 거의 비슷하지만 required 속성을 지원하지 않음.
	private WordDao wordDao;
	
	public WordRegisterService() {
	}
	
	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}