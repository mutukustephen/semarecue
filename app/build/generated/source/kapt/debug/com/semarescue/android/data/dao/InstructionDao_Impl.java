package com.semarescue.android.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.semarescue.android.data.entities.Instruction;
import com.semarescue.android.data.entities.Step;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class InstructionDao_Impl implements InstructionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Instruction> __insertionAdapterOfInstruction;

  private final EntityInsertionAdapter<Step> __insertionAdapterOfStep;

  public InstructionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInstruction = new EntityInsertionAdapter<Instruction>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `instructions` (`id`,`title_en`,`title_sw`,`icon_asset`,`category`,`keywords`,`description_en`,`description_sw`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Instruction entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle_en() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle_en());
        }
        if (entity.getTitle_sw() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTitle_sw());
        }
        if (entity.getIcon_asset() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getIcon_asset());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCategory());
        }
        if (entity.getKeywords() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getKeywords());
        }
        if (entity.getDescription_en() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDescription_en());
        }
        if (entity.getDescription_sw() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDescription_sw());
        }
      }
    };
    this.__insertionAdapterOfStep = new EntityInsertionAdapter<Step>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `steps` (`id`,`instruction_id`,`step_number`,`text_en`,`text_sw`,`audio_asset_en`,`audio_asset_sw`,`graphic_asset`,`timer_seconds`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Step entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getInstruction_id() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getInstruction_id());
        }
        statement.bindLong(3, entity.getStep_number());
        if (entity.getText_en() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getText_en());
        }
        if (entity.getText_sw() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getText_sw());
        }
        if (entity.getAudio_asset_en() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getAudio_asset_en());
        }
        if (entity.getAudio_asset_sw() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getAudio_asset_sw());
        }
        if (entity.getGraphic_asset() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getGraphic_asset());
        }
        if (entity.getTimer_seconds() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getTimer_seconds());
        }
      }
    };
  }

  @Override
  public Object insertInstructions(final List<Instruction> instructions,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInstruction.insert(instructions);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertSteps(final List<Step> steps, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStep.insert(steps);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Instruction>> getAllInstructions() {
    final String _sql = "SELECT * FROM instructions";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[] {"instructions"}, new Callable<List<Instruction>>() {
      @Override
      @NonNull
      public List<Instruction> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfTitleEn = CursorUtil.getColumnIndexOrThrow(_cursor, "title_en");
            final int _cursorIndexOfTitleSw = CursorUtil.getColumnIndexOrThrow(_cursor, "title_sw");
            final int _cursorIndexOfIconAsset = CursorUtil.getColumnIndexOrThrow(_cursor, "icon_asset");
            final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
            final int _cursorIndexOfKeywords = CursorUtil.getColumnIndexOrThrow(_cursor, "keywords");
            final int _cursorIndexOfDescriptionEn = CursorUtil.getColumnIndexOrThrow(_cursor, "description_en");
            final int _cursorIndexOfDescriptionSw = CursorUtil.getColumnIndexOrThrow(_cursor, "description_sw");
            final List<Instruction> _result = new ArrayList<Instruction>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final Instruction _item;
              final String _tmpId;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpId = null;
              } else {
                _tmpId = _cursor.getString(_cursorIndexOfId);
              }
              final String _tmpTitle_en;
              if (_cursor.isNull(_cursorIndexOfTitleEn)) {
                _tmpTitle_en = null;
              } else {
                _tmpTitle_en = _cursor.getString(_cursorIndexOfTitleEn);
              }
              final String _tmpTitle_sw;
              if (_cursor.isNull(_cursorIndexOfTitleSw)) {
                _tmpTitle_sw = null;
              } else {
                _tmpTitle_sw = _cursor.getString(_cursorIndexOfTitleSw);
              }
              final String _tmpIcon_asset;
              if (_cursor.isNull(_cursorIndexOfIconAsset)) {
                _tmpIcon_asset = null;
              } else {
                _tmpIcon_asset = _cursor.getString(_cursorIndexOfIconAsset);
              }
              final String _tmpCategory;
              if (_cursor.isNull(_cursorIndexOfCategory)) {
                _tmpCategory = null;
              } else {
                _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
              }
              final String _tmpKeywords;
              if (_cursor.isNull(_cursorIndexOfKeywords)) {
                _tmpKeywords = null;
              } else {
                _tmpKeywords = _cursor.getString(_cursorIndexOfKeywords);
              }
              final String _tmpDescription_en;
              if (_cursor.isNull(_cursorIndexOfDescriptionEn)) {
                _tmpDescription_en = null;
              } else {
                _tmpDescription_en = _cursor.getString(_cursorIndexOfDescriptionEn);
              }
              final String _tmpDescription_sw;
              if (_cursor.isNull(_cursorIndexOfDescriptionSw)) {
                _tmpDescription_sw = null;
              } else {
                _tmpDescription_sw = _cursor.getString(_cursorIndexOfDescriptionSw);
              }
              _item = new Instruction(_tmpId,_tmpTitle_en,_tmpTitle_sw,_tmpIcon_asset,_tmpCategory,_tmpKeywords,_tmpDescription_en,_tmpDescription_sw);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Instruction> getInstruction(final String id) {
    final String _sql = "SELECT * FROM instructions WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return CoroutinesRoom.createFlow(__db, true, new String[] {"instructions"}, new Callable<Instruction>() {
      @Override
      @Nullable
      public Instruction call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfTitleEn = CursorUtil.getColumnIndexOrThrow(_cursor, "title_en");
            final int _cursorIndexOfTitleSw = CursorUtil.getColumnIndexOrThrow(_cursor, "title_sw");
            final int _cursorIndexOfIconAsset = CursorUtil.getColumnIndexOrThrow(_cursor, "icon_asset");
            final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
            final int _cursorIndexOfKeywords = CursorUtil.getColumnIndexOrThrow(_cursor, "keywords");
            final int _cursorIndexOfDescriptionEn = CursorUtil.getColumnIndexOrThrow(_cursor, "description_en");
            final int _cursorIndexOfDescriptionSw = CursorUtil.getColumnIndexOrThrow(_cursor, "description_sw");
            final Instruction _result;
            if (_cursor.moveToFirst()) {
              final String _tmpId;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpId = null;
              } else {
                _tmpId = _cursor.getString(_cursorIndexOfId);
              }
              final String _tmpTitle_en;
              if (_cursor.isNull(_cursorIndexOfTitleEn)) {
                _tmpTitle_en = null;
              } else {
                _tmpTitle_en = _cursor.getString(_cursorIndexOfTitleEn);
              }
              final String _tmpTitle_sw;
              if (_cursor.isNull(_cursorIndexOfTitleSw)) {
                _tmpTitle_sw = null;
              } else {
                _tmpTitle_sw = _cursor.getString(_cursorIndexOfTitleSw);
              }
              final String _tmpIcon_asset;
              if (_cursor.isNull(_cursorIndexOfIconAsset)) {
                _tmpIcon_asset = null;
              } else {
                _tmpIcon_asset = _cursor.getString(_cursorIndexOfIconAsset);
              }
              final String _tmpCategory;
              if (_cursor.isNull(_cursorIndexOfCategory)) {
                _tmpCategory = null;
              } else {
                _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
              }
              final String _tmpKeywords;
              if (_cursor.isNull(_cursorIndexOfKeywords)) {
                _tmpKeywords = null;
              } else {
                _tmpKeywords = _cursor.getString(_cursorIndexOfKeywords);
              }
              final String _tmpDescription_en;
              if (_cursor.isNull(_cursorIndexOfDescriptionEn)) {
                _tmpDescription_en = null;
              } else {
                _tmpDescription_en = _cursor.getString(_cursorIndexOfDescriptionEn);
              }
              final String _tmpDescription_sw;
              if (_cursor.isNull(_cursorIndexOfDescriptionSw)) {
                _tmpDescription_sw = null;
              } else {
                _tmpDescription_sw = _cursor.getString(_cursorIndexOfDescriptionSw);
              }
              _result = new Instruction(_tmpId,_tmpTitle_en,_tmpTitle_sw,_tmpIcon_asset,_tmpCategory,_tmpKeywords,_tmpDescription_en,_tmpDescription_sw);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Step>> getStepsForInstruction(final String instructionId) {
    final String _sql = "SELECT * FROM steps WHERE instruction_id = ? ORDER BY step_number ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (instructionId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, instructionId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"steps"}, new Callable<List<Step>>() {
      @Override
      @NonNull
      public List<Step> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfInstructionId = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction_id");
          final int _cursorIndexOfStepNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "step_number");
          final int _cursorIndexOfTextEn = CursorUtil.getColumnIndexOrThrow(_cursor, "text_en");
          final int _cursorIndexOfTextSw = CursorUtil.getColumnIndexOrThrow(_cursor, "text_sw");
          final int _cursorIndexOfAudioAssetEn = CursorUtil.getColumnIndexOrThrow(_cursor, "audio_asset_en");
          final int _cursorIndexOfAudioAssetSw = CursorUtil.getColumnIndexOrThrow(_cursor, "audio_asset_sw");
          final int _cursorIndexOfGraphicAsset = CursorUtil.getColumnIndexOrThrow(_cursor, "graphic_asset");
          final int _cursorIndexOfTimerSeconds = CursorUtil.getColumnIndexOrThrow(_cursor, "timer_seconds");
          final List<Step> _result = new ArrayList<Step>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Step _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpInstruction_id;
            if (_cursor.isNull(_cursorIndexOfInstructionId)) {
              _tmpInstruction_id = null;
            } else {
              _tmpInstruction_id = _cursor.getString(_cursorIndexOfInstructionId);
            }
            final int _tmpStep_number;
            _tmpStep_number = _cursor.getInt(_cursorIndexOfStepNumber);
            final String _tmpText_en;
            if (_cursor.isNull(_cursorIndexOfTextEn)) {
              _tmpText_en = null;
            } else {
              _tmpText_en = _cursor.getString(_cursorIndexOfTextEn);
            }
            final String _tmpText_sw;
            if (_cursor.isNull(_cursorIndexOfTextSw)) {
              _tmpText_sw = null;
            } else {
              _tmpText_sw = _cursor.getString(_cursorIndexOfTextSw);
            }
            final String _tmpAudio_asset_en;
            if (_cursor.isNull(_cursorIndexOfAudioAssetEn)) {
              _tmpAudio_asset_en = null;
            } else {
              _tmpAudio_asset_en = _cursor.getString(_cursorIndexOfAudioAssetEn);
            }
            final String _tmpAudio_asset_sw;
            if (_cursor.isNull(_cursorIndexOfAudioAssetSw)) {
              _tmpAudio_asset_sw = null;
            } else {
              _tmpAudio_asset_sw = _cursor.getString(_cursorIndexOfAudioAssetSw);
            }
            final String _tmpGraphic_asset;
            if (_cursor.isNull(_cursorIndexOfGraphicAsset)) {
              _tmpGraphic_asset = null;
            } else {
              _tmpGraphic_asset = _cursor.getString(_cursorIndexOfGraphicAsset);
            }
            final Integer _tmpTimer_seconds;
            if (_cursor.isNull(_cursorIndexOfTimerSeconds)) {
              _tmpTimer_seconds = null;
            } else {
              _tmpTimer_seconds = _cursor.getInt(_cursorIndexOfTimerSeconds);
            }
            _item = new Step(_tmpId,_tmpInstruction_id,_tmpStep_number,_tmpText_en,_tmpText_sw,_tmpAudio_asset_en,_tmpAudio_asset_sw,_tmpGraphic_asset,_tmpTimer_seconds);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getInstructionCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM instructions";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
