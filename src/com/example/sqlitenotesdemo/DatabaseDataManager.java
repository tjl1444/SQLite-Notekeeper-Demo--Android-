package com.example.sqlitenotesdemo;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseDataManager {
	private Context mContext;
	private DatabaseOpenHelper dbOpenHelper;
	private SQLiteDatabase db;
	private NoteDAO noteDAO;
	
	public DatabaseDataManager(Context mContext){
		this.mContext = mContext;
		dbOpenHelper = new DatabaseOpenHelper(this.mContext);
		db = dbOpenHelper.getWritableDatabase();
		noteDAO = new NoteDAO(db);
	}
	
	public void close(){
		
		if(db != null){
			db.close();
		}
	}
	
	public NoteDAO getNoteDAO(){
		return this.noteDAO;
	}
	
	public long saveNote(Note note){
		return this.noteDAO.save(note);
	}
	
	public boolean updateNote(Note note){
		return this.noteDAO.update(note);
	}
	
	public boolean deleteNote (Note note){
		return this.noteDAO.delete(note);
	}
	
	public Note getNote(long id){
		return this.noteDAO.get(id);
	}
	
	public List<Note> getAllNotes(){
		return this.noteDAO.getAll();
	}
	
	
}
