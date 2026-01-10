package com.semarescue.android.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.semarescue.android.data.entities.IncidentLog;
import java.lang.Class;
import java.lang.Exception;
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
public final class IncidentLogDao_Impl implements IncidentLogDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<IncidentLog> __insertionAdapterOfIncidentLog;

  private final SharedSQLiteStatement __preparedStmtOfClearLogs;

  public IncidentLogDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIncidentLog = new EntityInsertionAdapter<IncidentLog>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `incident_log` (`id`,`timestamp`,`description`,`category`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final IncidentLog entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTimestamp());
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
      }
    };
    this.__preparedStmtOfClearLogs = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM incident_log";
        return _query;
      }
    };
  }

  @Override
  public Object insertLog(final IncidentLog log, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfIncidentLog.insert(log);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearLogs(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearLogs.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearLogs.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<IncidentLog>> getAllLogs() {
    final String _sql = "SELECT * FROM incident_log ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"incident_log"}, new Callable<List<IncidentLog>>() {
      @Override
      @NonNull
      public List<IncidentLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final List<IncidentLog> _result = new ArrayList<IncidentLog>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final IncidentLog _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _item = new IncidentLog(_tmpId,_tmpTimestamp,_tmpDescription,_tmpCategory);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
